package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class IncomeComparisonOperatorTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new IncomeComparisonOperator(null));
    }

    @Test
    public void constructor_invalidOperator_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new IncomeComparisonOperator("!"));
        assertThrows(IllegalArgumentException.class, () -> new IncomeComparisonOperator("=="));
        assertThrows(IllegalArgumentException.class, () -> new IncomeComparisonOperator(""));
    }

    @Test
    public void constructor_validOperator_success() {
        assertDoesNotThrow(() -> new IncomeComparisonOperator("="));
        assertDoesNotThrow(() -> new IncomeComparisonOperator(">"));
        assertDoesNotThrow(() -> new IncomeComparisonOperator("<"));
    }

    @Test
    public void isValidComparisonOperator() {
        // Test valid operators
        assertTrue(IncomeComparisonOperator.isValidComparisonOperator("="));
        assertTrue(IncomeComparisonOperator.isValidComparisonOperator(">"));
        assertTrue(IncomeComparisonOperator.isValidComparisonOperator("<"));

        // Test invalid operators
        assertFalse(IncomeComparisonOperator.isValidComparisonOperator("!"));
        assertFalse(IncomeComparisonOperator.isValidComparisonOperator("=="));
        assertFalse(IncomeComparisonOperator.isValidComparisonOperator(" "));
        assertFalse(IncomeComparisonOperator.isValidComparisonOperator(""));
        assertFalse(IncomeComparisonOperator.isValidComparisonOperator(">="));
    }

    @Test
    public void equals_sameObject_returnsTrue() {
        IncomeComparisonOperator operator = new IncomeComparisonOperator("=");
        assertEquals(operator, operator);
    }

    @Test
    public void equals_differentObjectsSameValue_returnsTrue() {
        IncomeComparisonOperator operator1 = new IncomeComparisonOperator(">");
        IncomeComparisonOperator operator2 = new IncomeComparisonOperator(">");
        assertEquals(operator1, operator2);
    }

    @Test
    public void equals_differentObjectsDifferentValue_returnsFalse() {
        IncomeComparisonOperator operator1 = new IncomeComparisonOperator(">");
        IncomeComparisonOperator operator2 = new IncomeComparisonOperator("<");
        assertNotEquals(operator1, operator2);
    }

    @Test
    public void hashCode_sameValue_returnsSameHashCode() {
        // Test that objects with the same value return the same hash code
        IncomeComparisonOperator operator1 = new IncomeComparisonOperator("<");
        IncomeComparisonOperator operator2 = new IncomeComparisonOperator("<");
        assertEquals(operator1.hashCode(), operator2.hashCode());
    }

    @Test
    public void hashCode_differentValues_returnsDifferentHashCodes() {
        // Test that objects with different values return different hash codes
        IncomeComparisonOperator operator1 = new IncomeComparisonOperator("=");
        IncomeComparisonOperator operator2 = new IncomeComparisonOperator(">");
        assertNotEquals(operator1.hashCode(), operator2.hashCode());
    }

    @Test
    public void toString_returnsCorrectString() {
        // Test that the toString method returns the correct string representation
        IncomeComparisonOperator operator = new IncomeComparisonOperator("=");
        assertEquals("=", operator.toString());
    }
}
