package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command {

    private static final boolean requiresConfirmation = false;

    /**
     * Executes the command and returns the result message.
     *
     * @param model                {@code Model} which the command should operate on and m
     * @param confirmationReceived A {@code Boolean} indicating whether user confirmation has been provided,
     *                             if required for executing the command.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    public CommandResult execute(Model model, Boolean confirmationReceived) throws CommandException {
        if (confirmationReceived.equals(requiresConfirmation)) {
            return this.execute(model);
        }
        return null;
    }

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    protected abstract CommandResult execute(Model model) throws CommandException;
}
