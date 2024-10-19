package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.ASSIGN_EVENT_PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.ASSIGN_VOLUNTEER_PREFIX_NAME;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.event.Event;
import seedu.address.model.exceptions.DuplicateAssignException;
import seedu.address.model.volunteer.Volunteer;

/**
 * Adds a volunteer to the system.
 */
public class AssignCommand extends Command {
    public static final String COMMAND_WORD = "assign";
    private static final String MESSAGE_DUPLICATE_ASSIGN = "Already assigned!";
    private static final String MESSAGE_SUCCESS = "Volunteer assigned successfully!";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Assigns a volunteer to an event."
            + "Parameters: "
            + ASSIGN_VOLUNTEER_PREFIX_NAME + "Volunteer Index "
            + ASSIGN_EVENT_PREFIX_NAME + "Event Index "
            + "Example: " + COMMAND_WORD + " "
            + ASSIGN_VOLUNTEER_PREFIX_NAME + "2 "
            + ASSIGN_EVENT_PREFIX_NAME + "3 ";

    /**
     * Creates a {@code VolunteerAddCommand} to add the specified {@code Volunteer}.
     *
     * @param volunteer The volunteer to be added.
     */
    private final Index volunteerIndex;
    private final Index eventIndex;

    /**
     * Constructs a {@code VolunteerAddCommand} that adds the specified {@code Volunteer} to the system.
     *
     * @param volunteerIndex The volunteer to be added. Must not be null.
     */
    public AssignCommand(Index volunteerIndex, Index eventIndex) {
        requireAllNonNull(volunteerIndex, eventIndex);
        this.volunteerIndex = volunteerIndex;
        this.eventIndex = eventIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireAllNonNull(model);

        System.out.println("We are assigning volunteer " + this.volunteerIndex + " to event " + this.eventIndex);

        List<Volunteer> lastShownVolunteerList = model.getFilteredVolunteerList();
        List<Event> lastShownEventList = model.getFilteredEventList();

        if (volunteerIndex.getZeroBased() >= lastShownVolunteerList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_VOLUNTEER_DISPLAYED_INDEX);
        }

        if (eventIndex.getZeroBased() >= lastShownEventList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_EVENT_DISPLAYED_INDEX);
        }

        Event e = lastShownEventList.get(eventIndex.getZeroBased());
        Volunteer v = lastShownVolunteerList.get(volunteerIndex.getZeroBased());

        try {
            model.assignVolunteerToEvent(v, e);
        } catch (DuplicateAssignException exception) {
            throw new CommandException(MESSAGE_DUPLICATE_ASSIGN);
        }

        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }
}
