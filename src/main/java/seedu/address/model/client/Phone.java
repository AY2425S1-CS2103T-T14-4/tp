package seedu.address.model.client;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Client's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPhone(String)}
 */
public class Phone {


    public static final String MESSAGE_CONSTRAINTS =
            "Phone numbers must be at least 8 digits long, start with 6, 8, or 9, and contain only numeric digits.";
    public static final String VALIDATION_REGEX = "^[689]\\d{7}$";
    private static final String PARTIAL_VALIDATION_REGEX = "\\d+";
    public final String value;

    /**
     * Constructs a {@code Phone}.
     *
     * @param phone A valid phone number.
     */
    public Phone(String phone) {
        requireNonNull(phone);
        checkArgument(isValidPhone(phone), MESSAGE_CONSTRAINTS);
        value = phone;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidPhone(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns true if a given string is a valid part of a phone number for filtering.
     *
     * - If the input length is exactly 8 digits, it must satisfy the full phone validation.
     * - If the input length is between 1 and 7 digits, it must be all numeric.
     * - If the input length is greater than 8, it is considered invalid.
     */
    public static boolean isValidPartialPhone(String test) {
        if (test.length() > 8) {
            return false;
        } else if (test.length() == 8) {
            return isValidPhone(test);
        } else {
            return test.matches(PARTIAL_VALIDATION_REGEX);
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Phone)) {
            return false;
        }

        Phone otherPhone = (Phone) other;
        return value.equals(otherPhone.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
