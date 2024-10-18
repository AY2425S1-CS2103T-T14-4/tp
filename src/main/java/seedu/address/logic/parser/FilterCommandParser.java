package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INCOME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOB;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import seedu.address.logic.commands.FilterCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Person;
import seedu.address.model.person.predicates.AddressContainsSubstringPredicate;
import seedu.address.model.person.predicates.CombinedPredicate;
import seedu.address.model.person.predicates.EmailContainsSubstringPredicate;
import seedu.address.model.person.predicates.IncomeComparisonPredicate;
import seedu.address.model.person.predicates.JobContainsSubstringPredicate;
import seedu.address.model.person.predicates.NameContainsSubstringPredicate;
import seedu.address.model.person.predicates.PhoneContainsSubstringPredicate;
import seedu.address.model.person.predicates.RemarkContainsSubstringPredicate;
import seedu.address.model.person.predicates.TierStartsWithSubstringPredicate;
import seedu.address.model.util.IncomeComparisonOperator;

/**
 * Parses input arguments and creates a new FilterCommand object
 */
public class FilterCommandParser implements Parser<FilterCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FilterCommand
     * and returns a FilterCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FilterCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS,
                        PREFIX_INCOME, PREFIX_JOB, PREFIX_REMARK, PREFIX_TIER);

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS,
                PREFIX_INCOME, PREFIX_JOB, PREFIX_REMARK, PREFIX_TIER);

        // Throw an error if no filters are used
        long numberOfFiltersUsed = countPrefixesUsed(argMultimap, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL,
                PREFIX_ADDRESS, PREFIX_JOB, PREFIX_INCOME, PREFIX_REMARK, PREFIX_TIER);

        if (numberOfFiltersUsed == 0) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_USAGE));
        }

        // Handle flags and search terms
        List<Predicate<Person>> predicates = collectPredicates(argMultimap);
        Predicate<Person> combinedPredicate = combinePredicates(predicates);

        return new FilterCommand(combinedPredicate);
    }

    /**
     * Counts the number of prefixes used in the given {@code ArgumentMultimap}.
     *
     * @param argMultimap The ArgumentMultimap containing the parsed arguments.
     * @param prefixes The prefixes to check in the argument map.
     * @return The number of prefixes that are present in the argument map.
     */
    private long countPrefixesUsed(ArgumentMultimap argMultimap, Prefix... prefixes) {
        return Arrays.stream(prefixes)
                .filter(prefix -> argMultimap.getValue(prefix).isPresent())
                .count();
    }

    /**
     * Collects the list of predicates based on the provided argument map.
     *
     * @param argMultimap The argument multimap containing the parsed arguments.
     * @return A list of predicates corresponding to the filters provided.
     * @throws ParseException if there are any parsing issues.
     */
    private List<Predicate<Person>> collectPredicates(ArgumentMultimap argMultimap) throws ParseException {
        // Collect individual predicates to be combined with AND operator later.
        // This "collection then combine" approach enhances testability by avoiding the use of anonymous
        // lambda predicates which ensures that the combined predicate can be easily tested and debugged.

        List<Predicate<Person>> predicates = new ArrayList<>();

        if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            String substring = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get()).fullName;
            predicates.add(new NameContainsSubstringPredicate(substring));
        }
        if (argMultimap.getValue(PREFIX_PHONE).isPresent()) {
            String substring = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get()).value;
            predicates.add(new PhoneContainsSubstringPredicate(substring));
        }
        if (argMultimap.getValue(PREFIX_EMAIL).isPresent()) {
            String substring = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get()).value;
            predicates.add(new EmailContainsSubstringPredicate(substring));
        }
        if (argMultimap.getValue(PREFIX_ADDRESS).isPresent()) {
            String substring = ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get()).value;
            predicates.add(new AddressContainsSubstringPredicate(substring));
        }
        if (argMultimap.getValue(PREFIX_JOB).isPresent()) {
            String substring = ParserUtil.parseJob(argMultimap.getValue(PREFIX_JOB).get()).value;
            predicates.add(new JobContainsSubstringPredicate(substring));
        }
        if (argMultimap.getValue(PREFIX_INCOME).isPresent()) {
            String operatorAndIncome = argMultimap.getValue(PREFIX_INCOME).get();

            IncomeComparisonOperator operator =
                    ParserUtil.parseIncomeComparisonOperator(operatorAndIncome.substring(0, 1));
            int income = ParserUtil.parseIncome(operatorAndIncome.substring(1)).value;

            predicates.add(new IncomeComparisonPredicate(operator, income));
        }
        if (argMultimap.getValue(PREFIX_REMARK).isPresent()) {
            String substring = ParserUtil.parseRemark(argMultimap.getValue(PREFIX_REMARK).get()).value;
            predicates.add(new RemarkContainsSubstringPredicate(substring));
        }
        if (argMultimap.getValue(PREFIX_TIER).isPresent()) {
            String substring = argMultimap.getValue(PREFIX_TIER).get();
            predicates.add(new TierStartsWithSubstringPredicate(substring));
        }
        return predicates;
    }

    /**
     * Combines the given list of predicates into a single predicate using the AND operator.
     * The combined predicate returns {@code true} only if all predicates return {@code true}.
     *
     * @param predicates The list of predicates to combine. Must not be null or empty.
     * @return A combined predicate that represents the logical AND of all provided predicates.
     * @throws IllegalArgumentException if the list of predicates is empty.
     */
    private Predicate<Person> combinePredicates(List<Predicate<Person>> predicates) {
        Objects.requireNonNull(predicates, "Predicates list must not be null");
        if (predicates.isEmpty()) {
            throw new IllegalArgumentException("Predicates list must not be empty");
        }

        return new CombinedPredicate(predicates);
    }
}
