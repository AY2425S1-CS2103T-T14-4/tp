package seedu.address.model.util;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Objects;

/**
 * Represents a comparison operator used in income comparisons.
 * The operator can only be one of '=', '>', or '<'.
 * Guarantees: comparisonOperator is validated upon creation.
 */
public class IncomeComparisonOperator {
    public static final String MESSAGE_CONSTRAINTS = "Please use a valid comparison operator. "
            + "Income comparison operators can only be '=', '>' or '<'.";

    public final String comparisonOperator;

    /**
     * Constructs a {@code IncomeComparisonOperator}.
     *
     * @param comparisonOperator A comparisonOperator
     */
    public IncomeComparisonOperator(String comparisonOperator) {
        requireNonNull(comparisonOperator);
        checkArgument(isValidComparisonOperator(comparisonOperator), MESSAGE_CONSTRAINTS);
        this.comparisonOperator = comparisonOperator;
    }

    /**
     * Returns true if a given string is a valid comparison operator.
     */
    public static boolean isValidComparisonOperator(String test) {
        if (test.trim().isEmpty()) {
            return false;
        }

        return (test.equals("=") || test.equals(">") || test.equals("<"));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof IncomeComparisonOperator) {
            IncomeComparisonOperator otherIncomeComparisonOperator = (IncomeComparisonOperator) other;
            return comparisonOperator.equals(otherIncomeComparisonOperator.comparisonOperator);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(comparisonOperator);
    }

    @Override
    public String toString() {
        return comparisonOperator;
    }
}
