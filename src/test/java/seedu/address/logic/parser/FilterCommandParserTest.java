package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FilterCommand;
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

public class FilterCommandParserTest {

    private FilterCommandParser parser = new FilterCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFilterCommand() {
        List<Predicate<Person>> expectedPredicates = new ArrayList<>();
        expectedPredicates.add(new NameContainsSubstringPredicate("Alice"));
        FilterCommand expectedFilterCommand = new FilterCommand(new CombinedPredicate(expectedPredicates));

        assertParseSuccess(parser, " n/ Alice", expectedFilterCommand);
    }

    @Test
    public void parse_addressFlag_returnsAddressFilterCommand() {
        List<Predicate<Person>> expectedPredicates = new ArrayList<>();
        expectedPredicates.add(new AddressContainsSubstringPredicate("Block 123"));
        FilterCommand expectedFilterCommand = new FilterCommand(new CombinedPredicate(expectedPredicates));

        assertParseSuccess(parser, " a/ Block 123", expectedFilterCommand);
    }

    @Test
    public void parse_emailFlag_returnsEmailFilterCommand() {
        List<Predicate<Person>> expectedPredicates = new ArrayList<>();
        expectedPredicates.add(new EmailContainsSubstringPredicate("alice@hello.com"));
        FilterCommand expectedFilterCommand = new FilterCommand(new CombinedPredicate(expectedPredicates));

        assertParseSuccess(parser, " e/ alice@hello.com", expectedFilterCommand);
    }

    @Test
    public void parse_incomeFlag_returnsIncomeFilterCommand() {
        List<Predicate<Person>> expectedPredicates = new ArrayList<>();
        expectedPredicates.add(new EmailContainsSubstringPredicate("alice@hello.com"));
        FilterCommand expectedFilterCommand = new FilterCommand(new CombinedPredicate(expectedPredicates));

        assertParseSuccess(parser, " e/ alice@hello.com", expectedFilterCommand);
    }

    @Test
    public void parse_jobFlag_returnsRemarkFilterCommand() {
        List<Predicate<Person>> expectedPredicates = new ArrayList<>();
        IncomeComparisonOperator operator = new IncomeComparisonOperator(">");
        expectedPredicates.add(new IncomeComparisonPredicate(operator, 5000));

        FilterCommand expectedFilterCommand = new FilterCommand(new CombinedPredicate(expectedPredicates));

        assertParseSuccess(parser, " i/ >5000", expectedFilterCommand);
    }

    @Test
    public void parse_nameFlag_returnsNameFilterCommand() {
        List<Predicate<Person>> expectedPredicates = new ArrayList<>();
        expectedPredicates.add(new NameContainsSubstringPredicate("Alice"));
        FilterCommand expectedFilterCommand = new FilterCommand(new CombinedPredicate(expectedPredicates));

        assertParseSuccess(parser, " n/ Alice", expectedFilterCommand);
    }

    @Test
    public void parse_phoneFlag_returnsPhoneFilterCommand() {
        List<Predicate<Person>> expectedPredicates = new ArrayList<>();
        expectedPredicates.add(new PhoneContainsSubstringPredicate("91112222"));
        FilterCommand expectedFilterCommand = new FilterCommand(new CombinedPredicate(expectedPredicates));

        assertParseSuccess(parser, " p/ 91112222", expectedFilterCommand);
    }


    @Test
    public void parse_remarkFlag_returnsRemarkFilterCommand() {
        List<Predicate<Person>> expectedPredicates = new ArrayList<>();
        expectedPredicates.add(new RemarkContainsSubstringPredicate("is a celebrity"));
        FilterCommand expectedFilterCommand = new FilterCommand(new CombinedPredicate(expectedPredicates));

        assertParseSuccess(parser, " r/ is a celebrity", expectedFilterCommand);
    }

    @Test
    public void parse_tierFlag_returnsRemarkFilterCommand() {
        List<Predicate<Person>> expectedPredicates = new ArrayList<>();
        expectedPredicates.add(new TierStartsWithSubstringPredicate("gOLD"));
        FilterCommand expectedFilterCommand = new FilterCommand(new CombinedPredicate(expectedPredicates));

        assertParseSuccess(parser, " t/ GOLD", expectedFilterCommand);
    }

    @Test
    public void parse_validMultipleArgs_returnsFilterCommand() {
        List<Predicate<Person>> expectedPredicates = new ArrayList<>();
        expectedPredicates.add(new NameContainsSubstringPredicate("Alice"));
        expectedPredicates.add(new PhoneContainsSubstringPredicate("91112222"));
        expectedPredicates.add(new EmailContainsSubstringPredicate("alice@example.com"));
        expectedPredicates.add(new AddressContainsSubstringPredicate("Block 123"));
        expectedPredicates.add(new JobContainsSubstringPredicate("Software Engineer"));
        IncomeComparisonOperator operator = new IncomeComparisonOperator(">");
        expectedPredicates.add(new IncomeComparisonPredicate(operator, 5000));
        expectedPredicates.add(new RemarkContainsSubstringPredicate("is a celebrity"));
        expectedPredicates.add(new TierStartsWithSubstringPredicate("GOLD"));

        FilterCommand expectedFilterCommand = new FilterCommand(new CombinedPredicate(expectedPredicates));

        assertParseSuccess(parser, " n/ Alice p/ 91112222 e/ alice@example.com a/ Block 123 "
                + "j/ Software Engineer i/ >5000 r/ is a celebrity t/ gold", expectedFilterCommand);
    }

    @Test
    public void parse_validMultipleArgsWithWhitespace_returnsFilterCommand() {
        List<Predicate<Person>> expectedPredicates = new ArrayList<>();
        expectedPredicates.add(new NameContainsSubstringPredicate("Alice"));
        expectedPredicates.add(new PhoneContainsSubstringPredicate("91112222"));

        FilterCommand expectedFilterCommand = new FilterCommand(new CombinedPredicate(expectedPredicates));

        assertParseSuccess(parser, " n/  \t Alice \n p/  \t 91112222 ", expectedFilterCommand);
    }
}
