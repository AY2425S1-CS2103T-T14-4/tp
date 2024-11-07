package seedu.address.logic;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.client.Client;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command!";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_CLIENT_DISPLAYED_INDEX = "The client index provided is invalid.";
    public static final String MESSAGE_CLIENTS_LISTED_OVERVIEW = "%1$d client(s) listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
                "Multiple values specified for the following single-valued field(s): ";

    public static final String MESSAGE_CONCURRENT_RN_RA_FIELDS = "Both remark new and remark append fields are "
            + "specified, please only use one.";

    public static final String MESSAGE_COMMAND_CANCELLED = "Command has been cancelled.";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toCollection(LinkedHashSet::new));

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code client} for display to the user.
     */
    public static String format(Client client) {
        final StringBuilder builder = new StringBuilder();
        builder.append(client.getName())
                .append("; Phone: ")
                .append(client.getPhone())
                .append("; Email: ")
                .append(client.getEmail())
                .append("; Address: ")
                .append(client.getAddress())
                .append("; Job: ")
                .append(client.getJob())
                .append("; Income: ")
                .append(client.getIncome())
                .append("; Tier: ")
                .append(client.getTier())
                .append("; Remark: ")
                .append(client.getRemark())
                .append("; Status: ")
                .append(client.getStatus());
        return builder.toString();
    }

}
