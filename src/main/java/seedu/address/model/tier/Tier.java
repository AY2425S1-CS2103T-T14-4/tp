package seedu.address.model.tier;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Tag in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTagName(String)}
 */
public class Tier {

    public static final String MESSAGE_CONSTRAINTS =
            "The Tiers are Gold, Silver, Bronze and Reject. Please use one of them.";

    public final TierEnum tagName;

    /**
     * Constructs a {@code Tag}.
     *
     * @param tagName A valid tag name.
     */
    public Tier(String tagName) {
        requireNonNull(tagName);
        checkArgument(isValidTagName(tagName), MESSAGE_CONSTRAINTS);
        this.tagName = TierEnum.valueOf(tagName.toUpperCase());;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidTagName(String test) {
        for (TierEnum c : TierEnum.values()) {
            if (c.name().equals(test.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Tier)) {
            return false;
        }

        Tier otherTier = (Tier) other;
        return tagName.equals(otherTier.tagName);
    }

    @Override
    public int hashCode() {
        return tagName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + tagName.toString() + ']';
    }

    /**
     * The Enums for what values Tier can take.
     */
    public enum TierEnum {
        GOLD,
        SILVER,
        BRONZE,
        REJECT,
        NA
    }

}
