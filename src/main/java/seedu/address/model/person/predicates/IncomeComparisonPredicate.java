package seedu.address.model.person.predicates;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;
import seedu.address.model.util.IncomeComparisonOperator;

/**
 * Predicate that compares a {@code Person}'s income against a threshold using a specified comparison operator.
 */
public class IncomeComparisonPredicate implements Predicate<Person> {
    private final int incomeThreshold;
    private final IncomeComparisonOperator incomeComparisonOperator;

    /**
     * Constructs an {@code IncomeComparisonPredicate}.
     *
     * @param incomeComparisonOperator The operator used to compare the person's income with the threshold.
     * @param incomeThreshold          The threshold income to compare against.
     */
    public IncomeComparisonPredicate(IncomeComparisonOperator incomeComparisonOperator, int incomeThreshold) {
        requireNonNull(incomeComparisonOperator);
        this.incomeThreshold = incomeThreshold;
        this.incomeComparisonOperator = incomeComparisonOperator;
    }

    @Override
    public boolean test(Person person) {
        int personIncome = person.getIncome().value;

        switch (incomeComparisonOperator.comparisonOperator) {
        case "=":
            return personIncome == incomeThreshold;
        case ">":
            return personIncome > incomeThreshold;
        case "<":
            return personIncome < incomeThreshold;
        default:
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof IncomeComparisonPredicate)) {
            return false;
        }

        IncomeComparisonPredicate otherIncomeComparisonPredicate =
                (IncomeComparisonPredicate) other;
        return incomeThreshold == otherIncomeComparisonPredicate.incomeThreshold
                && incomeComparisonOperator.equals(otherIncomeComparisonPredicate.incomeComparisonOperator);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("incomeThreshold", incomeThreshold)
                .add("incomeComparisonOperator", incomeComparisonOperator)
                .toString();
    }
}

