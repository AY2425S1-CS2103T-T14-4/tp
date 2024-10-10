package seedu.address.commons.util;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Helper functions for handling strings.
 */
public class StringUtil {

    /**
     * Returns true if the {@code sentence} contains the {@code substring}.
     *   Ignores case, does not require full word match.
     *   <br>examples:<pre>
     *       containsWordIgnoreCase("ABc def", "abc") == true
     *       containsWordIgnoreCase("ABc def", "DEF") == true
     *       containsWordIgnoreCase("ABc def", "AB") == true
     *       containsWordIgnoreCase("ABc def", "cde") == false // Sentence does not contain substring.
     *       containsWordIgnoreCase("ABc def", "c de") == true
     *       </pre>
     * @param sentence cannot be null
     * @param substring cannot be null, cannot be empty
     */
    public static boolean containsSubstringIgnoreCase(String sentence, String substring) {
        requireNonNull(sentence);
        requireNonNull(substring);

        String preppedSubstring = substring.trim();
        checkArgument(!preppedSubstring.isEmpty(), "Substring parameter cannot be empty");

        // Convert both sentence and substring to lower case to ignore case
        String lowerCaseSentence = sentence.toLowerCase();
        String lowerCaseSubstring = preppedSubstring.toLowerCase();

        return lowerCaseSentence.contains(lowerCaseSubstring);
    }

    /**
     * Returns a detailed message of the t, including the stack trace.
     */
    public static String getDetails(Throwable t) {
        requireNonNull(t);
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        return t.getMessage() + "\n" + sw.toString();
    }

    /**
     * Returns true if {@code s} represents a non-zero unsigned integer
     * e.g. 1, 2, 3, ..., {@code Integer.MAX_VALUE} <br>
     * Will return false for any other non-null string input
     * e.g. empty string, "-1", "0", "+1", and " 2 " (untrimmed), "3 0" (contains whitespace), "1 a" (contains letters)
     * @throws NullPointerException if {@code s} is null.
     */
    public static boolean isNonZeroUnsignedInteger(String s) {
        requireNonNull(s);

        try {
            int value = Integer.parseInt(s);
            return value > 0 && !s.startsWith("+"); // "+1" is successfully parsed by Integer#parseInt(String)
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
