package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";
    public static final String MESSAGE_CLEAR_CONFIRMATION = "This will permanently clear all contacts. "
            + "Are you sure you want to execute this command? (y/n)";

    private static final boolean requiresConfirmation = true;

    @Override
    protected CommandResult execute(Model model) {
        requireNonNull(model);
        model.setAddressBook(new AddressBook());
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public CommandResult execute(Model model, Boolean confirmationReceived) {
        if (confirmationReceived.equals(requiresConfirmation)) {
            return this.execute(model);
        }
        return new CommandResult(MESSAGE_CLEAR_CONFIRMATION, false, false, true);
    }

}
