package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.client.Client;

/**
 * Finds and lists all clients in address book whose name contains the substring.
 * Substring matching is case-insensitive.
 */
public class FilterCommand extends Command {

    public static final String COMMAND_WORD = "filter";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Searches for all clients whose specified field "
            + "contains the given substring (case-insensitive) and displays the results in a numbered list.\n"
            + "Parameters: <FLAG>/ <SEARCH TERM>\n"
            + "Flags: n/ NAME, p/ PHONE, e/ EMAIL, a/ ADDRESS, j/ JOB, i/ (=/</>) INCOME r/ REMARK t/ TIER s/ STATUS\n"
            + "Example: '" + COMMAND_WORD + " n/ Alice p/ 91112222 i/ >2000";

    private final Predicate<Client> predicate;

    public FilterCommand(Predicate<Client> predicate) {
        this.predicate = predicate;
    }

    @Override
    protected CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredClientList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_CLIENTS_LISTED_OVERVIEW, model.getFilteredClientList().size()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FilterCommand)) {
            return false;
        }

        FilterCommand otherFilterCommand = (FilterCommand) other;
        return predicate.equals(otherFilterCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicates", predicate)
                .toString();
    }
}
