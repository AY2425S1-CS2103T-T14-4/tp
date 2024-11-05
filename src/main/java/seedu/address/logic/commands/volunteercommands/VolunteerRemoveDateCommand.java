package seedu.address.logic.commands.volunteercommands;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.exceptions.VolunteerDeleteMissingDateException;
import seedu.address.model.exceptions.VolunteerDuplicateDateException;
import seedu.address.model.volunteer.Volunteer;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class VolunteerRemoveDateCommand extends Command {

    public static final String COMMAND_WORD = "unfree";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Removes dates from the list of available dates of volunteer identified by the index number "
            + "used in the displayed volunteer list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " i/1 d/2202-01-12, 2022-02-11";
    private static final String MESSAGE_REMOVE_DATE_VOLUNTEER_SUCCESS =
            "Removed dates from %s's list of available dates.";

    private final Index targetIndex;
    private final String dateList;

    /**
     * Constructor. Takes in a non-zero, non-negative index and a list of dates formatted as a single string.
     * @param targetIndex
     * @param dateList
     */
    public VolunteerRemoveDateCommand(Index targetIndex, String dateList) {
        this.targetIndex = targetIndex;
        this.dateList = dateList;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Volunteer> lastShownList = model.getFilteredVolunteerList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_VOLUNTEER_DISPLAYED_INDEX);
        }

        try {
            Volunteer volunteerToRemoveDate = lastShownList.get(targetIndex.getZeroBased());
            model.removeDatesFromVolunteer(volunteerToRemoveDate, dateList);
            return new CommandResult(String.format(MESSAGE_REMOVE_DATE_VOLUNTEER_SUCCESS,
                    volunteerToRemoveDate.getName().toString()));
        } catch (VolunteerDeleteMissingDateException e) {
            throw new CommandException(e.getMessage());
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof VolunteerRemoveDateCommand)) {
            return false;
        }

        VolunteerRemoveDateCommand otherViewCommand = (VolunteerRemoveDateCommand) other;
        return targetIndex.equals(otherViewCommand.targetIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}
