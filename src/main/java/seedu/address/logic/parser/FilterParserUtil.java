package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.client.Email;
import seedu.address.model.client.Phone;
import seedu.address.model.util.IncomeComparisonOperator;

/**
 * Contains utility methods used for parsing strings (for filtering purposes) in the various *Parser classes.
 */
public class FilterParserUtil extends ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";
    public static final String TIER_NO_VALUE_PROVIDED_MESSAGE = "Tier has not been provided any value to filter by.\n"
            + "Please specify a tier label to filter by, such as 'Gold', 'Silver', 'Bronze', 'Reject', or 'NA'.\n"
            + "To filter for clients without a visible tier label beside their name, use: filter t/ NA";
    public static final String STATUS_NO_VALUE_PROVIDED_MESSAGE = "Status has not been provided any value "
            + "to filter by.\n"
            + "Please specify a status label to filter by, such as 'Urgent', 'Non_Urgent', or 'NA'.\n"
            + "To filter for clients without a visible status label beside their name, use: filter s/ NA";
    public static final String INVALID_PARTIAL_PHONE_MESSAGE =
            "When using the filter command, the phone number input:\n"
            + "- Must contain only numeric digits\n"
            + "- Numbers with fewer than 8 digits are allowed\n"
            + "- Numbers longer than 8 digits are not allowed\n"
            + "- If exactly 8 digits, the number must start with 6, 8, or 9";

    public static final String INVALID_PARTIAL_EMAIL_MESSAGE =
            "When using the filter command, the email input may be a full or partial email address and must "
                    + "contain only alphanumeric characters, the symbols '+', '_', '.', or '-', and an optional '@'.";

    /**
     * Parses a {@code String phone} into a {@code String} containing the phone number.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is an invalid partial phone number.
     */
    public static String parsePartialPhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPartialPhone(trimmedPhone)) {
            throw new ParseException(INVALID_PARTIAL_PHONE_MESSAGE);
        }
        return trimmedPhone;
    }

    /**
     * Parses a partial {@code String email} into an {@code String}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is an invalid partial email.
     */
    public static String parsePartialEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidPartialEmail(trimmedEmail)) {
            throw new ParseException(INVALID_PARTIAL_EMAIL_MESSAGE);
        }
        return trimmedEmail;
    }

    /**
     * Parses a partial {@code String tier} into a {@code String}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tier} is invalid.
     */
    public static String parsePartialTier(String tier) throws ParseException {
        requireNonNull(tier);
        String trimmedTier = tier.trim();
        if (trimmedTier.isEmpty()) {
            throw new ParseException(TIER_NO_VALUE_PROVIDED_MESSAGE);
        }
        return trimmedTier;
    }

    /**
     * Parses a {@code String status} into a {@code String}.
     * Leading and trailing whitespaces are trimmed.
     *
     * @throws ParseException if the given {@code status} is invalid.
     */
    public static String parsePartialStatus(String status) throws ParseException {
        requireNonNull(status);
        String trimmedStatus = status.trim();
        if (trimmedStatus.isEmpty()) {
            throw new ParseException(STATUS_NO_VALUE_PROVIDED_MESSAGE);
        }
        return trimmedStatus;
    }

    /**
     * Parses a {@code String operator} into a {@code IncomeComparisonOperator}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code operator} is invalid.
     */
    public static IncomeComparisonOperator parseIncomeComparisonOperator(String operator) throws ParseException {
        requireNonNull(operator);
        String trimmedOperator = operator.trim();
        if (!IncomeComparisonOperator.isValidComparisonOperator(trimmedOperator)) {
            throw new ParseException(IncomeComparisonOperator.MESSAGE_CONSTRAINTS);
        }
        return new IncomeComparisonOperator(trimmedOperator);
    }

}
