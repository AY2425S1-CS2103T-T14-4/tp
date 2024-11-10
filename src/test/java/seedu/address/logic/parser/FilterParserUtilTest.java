package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.client.Address;
import seedu.address.model.client.Email;
import seedu.address.model.client.Income;
import seedu.address.model.client.Name;
import seedu.address.model.status.Status;
import seedu.address.model.tier.Tier;
import seedu.address.model.util.IncomeComparisonOperator;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.parser.FilterParserUtil.MESSAGE_INVALID_INDEX;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_CLIENT;

public class FilterParserUtilTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE_1 = "9123 4567";
    private static final String INVALID_PHONE_2 = "12345678";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "@@@@example.com";
    private static final String INVALID_INCOME = "one thousand";
    private static final String INVALID_TIER_1 = "#friend";
    private static final String INVALID_TIER_2 = "NA";
    private static final String INVALID_STATUS_1 = "#friend";
    private static final String INVALID_STATUS_2 = "NA";
    private static final String INVALID_INCOME_COMPARISON_OPERATOR_1 = "==";
    private static final String INVALID_INCOME_COMPARISON_OPERATOR_2 = "!";

    private static final String VALID_NAME = "Rachel Walker";
    private static final String VALID_PHONE = "91234567";
    private static final String VALID_PARTIAL_PHONE = "9123";
    private static final String VALID_ADDRESS = "123 Main Street #0505";
    private static final String VALID_EMAIL = "rachel@example.com";
    private static final String VALID_PARTIAL_EMAIL = "example.co";
    private static final String VALID_INCOME = "1000";
    private static final String VALID_TIER_1 = "BRONZE";
    private static final String VALID_TIER_2 = "SILVER";
    private static final String VALID_TIER_3 = "SIL";
    private static final String VALID_STATUS_1 = "URGENT";
    private static final String VALID_STATUS_2 = "NON_urGent";
    private static final String VALID_STATUS_3 = "NON_";
    private static final String VALID_INCOME_COMPARISON_OPERATOR_EQUAL = ">";
    private static final String VALID_INCOME_COMPARISON_OPERATOR_GREATER_THAN = ">";
    private static final String VALID_INCOME_COMPARISON_OPERATOR_LESS_THAN = "<";

    private static final String WHITESPACE = " \t\r\n";

    @Test
    public void parseIndex_invalidInput_throwsParseException() {
        assertThrows(ParseException.class, () -> FilterParserUtil.parseIndex("10 a"));
    }

    @Test
    public void parseIndex_outOfRangeInput_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_INVALID_INDEX, ()
            -> FilterParserUtil.parseIndex(Long.toString(Integer.MAX_VALUE + 1)));
    }

    @Test
    public void parseIndex_validInput_success() throws Exception {
        // No whitespaces
        assertEquals(INDEX_FIRST_CLIENT, FilterParserUtil.parseIndex("1"));

        // Leading and trailing whitespaces
        assertEquals(INDEX_FIRST_CLIENT, FilterParserUtil.parseIndex("  1  "));
    }

    @Test
    public void parseName_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> FilterParserUtil.parseName((String) null));
    }

    @Test
    public void parseName_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> FilterParserUtil.parseName(INVALID_NAME));
    }

    @Test
    public void parseName_validValueWithoutWhitespace_returnsName() throws Exception {
        Name expectedName = new Name(VALID_NAME);
        assertEquals(expectedName, FilterParserUtil.parseName(VALID_NAME));
    }

    @Test
    public void parseName_validValueWithWhitespace_returnsTrimmedName() throws Exception {
        String nameWithWhitespace = WHITESPACE + VALID_NAME + WHITESPACE;
        Name expectedName = new Name(VALID_NAME);
        assertEquals(expectedName, FilterParserUtil.parseName(nameWithWhitespace));
    }

    @Test
    public void parsePartialPhone_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> FilterParserUtil.parsePartialPhone((String) null));
    }

    @Test
    public void parsePartialPhone_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> FilterParserUtil.parsePartialPhone(INVALID_PHONE_1));
        assertThrows(ParseException.class, () -> FilterParserUtil.parsePartialPhone(INVALID_PHONE_2));
    }

    @Test
    public void parsePartialPhone_validValueWithoutWhitespace_returnsString() throws Exception {
        assertEquals(VALID_PHONE, FilterParserUtil.parsePartialPhone(VALID_PHONE));
        assertEquals(VALID_PARTIAL_PHONE, FilterParserUtil.parsePartialPhone(VALID_PARTIAL_PHONE));
    }

    @Test
    public void parsePhone_validValueWithWhitespace_returnsTrimmedPhone() throws Exception {
        String phoneWithWhitespace = WHITESPACE + VALID_PHONE + WHITESPACE;
        assertEquals(VALID_PHONE.trim(), FilterParserUtil.parsePartialPhone(phoneWithWhitespace));
    }

    @Test
    public void parseAddress_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> FilterParserUtil.parseAddress((String) null));
    }

    @Test
    public void parseAddress_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> FilterParserUtil.parseAddress(INVALID_ADDRESS));
    }

    @Test
    public void parseAddress_validValueWithoutWhitespace_returnsAddress() throws Exception {
        Address expectedAddress = new Address(VALID_ADDRESS);
        assertEquals(expectedAddress, FilterParserUtil.parseAddress(VALID_ADDRESS));
    }

    @Test
    public void parseAddress_validValueWithWhitespace_returnsTrimmedAddress() throws Exception {
        String addressWithWhitespace = WHITESPACE + VALID_ADDRESS + WHITESPACE;
        Address expectedAddress = new Address(VALID_ADDRESS);
        assertEquals(expectedAddress, FilterParserUtil.parseAddress(addressWithWhitespace));
    }

    @Test
    public void parsePartialEmail_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> FilterParserUtil.parsePartialEmail((String) null));
    }

    @Test
    public void parsePartialEmail_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> FilterParserUtil.parsePartialEmail(INVALID_EMAIL));
    }

    @Test
    public void parsePartialEmail_validValueWithoutWhitespace_returnsString() throws Exception {
        assertEquals(VALID_EMAIL, FilterParserUtil.parsePartialEmail(VALID_EMAIL));
        assertEquals(VALID_PARTIAL_EMAIL, FilterParserUtil.parsePartialEmail(VALID_PARTIAL_EMAIL));
    }

    @Test
    public void parseEmail_validValueWithWhitespace_returnsTrimmedString() throws Exception {
        String emailWithWhitespace = WHITESPACE + VALID_EMAIL + WHITESPACE;
        assertEquals(VALID_EMAIL, FilterParserUtil.parsePartialEmail(emailWithWhitespace));
    }

    @Test
    public void parseIncome_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> FilterParserUtil.parseIncome((String) null));
    }

    @Test
    public void parseIncome_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> FilterParserUtil.parseIncome(INVALID_INCOME));
    }

    @Test
    public void parseIncome_validValueWithoutWhitespace_returnsEmail() throws Exception {
        Income expectedIncome = new Income(new BigInteger(VALID_INCOME));
        assertEquals(expectedIncome, FilterParserUtil.parseIncome(VALID_INCOME));
    }

    @Test
    public void parseIncome_validValueWithWhitespace_returnsTrimmedIncome() throws Exception {
        String incomeWithWhitespace = WHITESPACE + VALID_INCOME + WHITESPACE;
        Income expectedIncome = new Income(new BigInteger(VALID_INCOME));
        assertEquals(expectedIncome, FilterParserUtil.parseIncome(incomeWithWhitespace));
    }

    @Test
    public void parsePartialTier_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> FilterParserUtil.parseTier(null));
    }

    @Test
    public void parsePartialTier_validValueWithoutWhitespace_returnsString() throws Exception {
        assertEquals(VALID_TIER_1, FilterParserUtil.parsePartialTier(VALID_TIER_1));
        assertEquals(VALID_TIER_2, FilterParserUtil.parsePartialTier(VALID_TIER_2));
        assertEquals(VALID_TIER_3, FilterParserUtil.parsePartialTier(VALID_TIER_3));
    }

    @Test
    public void parsePartialTier_validValueWithWhitespace_returnsTrimmedString() throws Exception {
        String tierWithWhitespace = WHITESPACE + VALID_TIER_1 + WHITESPACE;
        assertEquals(VALID_TIER_1, FilterParserUtil.parsePartialTier(tierWithWhitespace));
    }

    @Test
    public void parsePartialStatus_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> FilterParserUtil.parsePartialStatus(null));
    }

    @Test
    public void parseStatus_validValueWithoutWhitespace_returnsString() throws Exception {
        assertEquals(VALID_STATUS_1, FilterParserUtil.parsePartialStatus(VALID_STATUS_1));
        assertEquals(VALID_STATUS_2, FilterParserUtil.parsePartialStatus(VALID_STATUS_2));
        assertEquals(VALID_STATUS_3, FilterParserUtil.parsePartialStatus(VALID_STATUS_3));
    }

    @Test
    public void parseStatus_validValueWithWhitespace_returnsTrimmedString() throws Exception {
        String statusWithWhitespace = WHITESPACE + VALID_STATUS_1 + WHITESPACE;
        assertEquals(VALID_STATUS_1, FilterParserUtil.parsePartialStatus(statusWithWhitespace));
    }

    @Test
    public void parseIncomeComparisonOperator_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> FilterParserUtil.parseIncomeComparisonOperator(null));
    }

    @Test
    public void parseIncomeComparisonOperator_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () ->
                FilterParserUtil.parseIncomeComparisonOperator(INVALID_INCOME_COMPARISON_OPERATOR_1));
        assertThrows(ParseException.class, () ->
                FilterParserUtil.parseIncomeComparisonOperator(INVALID_INCOME_COMPARISON_OPERATOR_2));
    }

    @Test
    public void parseIncomeComparisonOperator_validValueWithoutWhitespace_returnsIncomeComparisonOperator()
            throws Exception {
        IncomeComparisonOperator equalOperator = new IncomeComparisonOperator(
                VALID_INCOME_COMPARISON_OPERATOR_EQUAL);
        IncomeComparisonOperator greaterThanOperator = new IncomeComparisonOperator(
                VALID_INCOME_COMPARISON_OPERATOR_GREATER_THAN);
        IncomeComparisonOperator lessThanOperator = new IncomeComparisonOperator(
                VALID_INCOME_COMPARISON_OPERATOR_LESS_THAN);

        assertEquals(equalOperator, FilterParserUtil.parseIncomeComparisonOperator(
                VALID_INCOME_COMPARISON_OPERATOR_EQUAL));
        assertEquals(greaterThanOperator, FilterParserUtil.parseIncomeComparisonOperator(
                VALID_INCOME_COMPARISON_OPERATOR_GREATER_THAN));
        assertEquals(lessThanOperator, FilterParserUtil.parseIncomeComparisonOperator(
                VALID_INCOME_COMPARISON_OPERATOR_LESS_THAN));
    }

    @Test
    public void parseIncomeComparisonOperator_validValueWithWhitespace_returnsIncomeComparisonOperator()
            throws Exception {
        IncomeComparisonOperator equalOperator = new IncomeComparisonOperator(
                VALID_INCOME_COMPARISON_OPERATOR_EQUAL);
        IncomeComparisonOperator greaterThanOperator = new IncomeComparisonOperator(
                VALID_INCOME_COMPARISON_OPERATOR_GREATER_THAN);
        IncomeComparisonOperator lessThanOperator = new IncomeComparisonOperator(
                VALID_INCOME_COMPARISON_OPERATOR_LESS_THAN);

        assertEquals(equalOperator, FilterParserUtil.parseIncomeComparisonOperator(
                WHITESPACE + VALID_INCOME_COMPARISON_OPERATOR_EQUAL + WHITESPACE));
        assertEquals(greaterThanOperator, FilterParserUtil.parseIncomeComparisonOperator(
                WHITESPACE + VALID_INCOME_COMPARISON_OPERATOR_GREATER_THAN + WHITESPACE));
        assertEquals(lessThanOperator, FilterParserUtil.parseIncomeComparisonOperator(
                WHITESPACE + VALID_INCOME_COMPARISON_OPERATOR_LESS_THAN + WHITESPACE));
    }

}
