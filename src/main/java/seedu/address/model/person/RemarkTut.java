package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class RemarkTut {
    public static final String MESSAGE_CONSTRAINTS = "Addresses can take any values, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String remark;

    /**
     * Constructs an {@code Remark}.
     *
     * @param remark A valid Remark.
     */
    public RemarkTut(String remark) {
        requireNonNull(remark);
        this.remark = remark;
    }

    @Override
    public String toString() {
        return remark;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RemarkTut)) {
            return false;
        }

        RemarkTut otherAddress = (RemarkTut) other;
        return remark.equals(otherAddress.remark);
    }

    @Override
    public int hashCode() {
        return remark.hashCode();
    }
}
