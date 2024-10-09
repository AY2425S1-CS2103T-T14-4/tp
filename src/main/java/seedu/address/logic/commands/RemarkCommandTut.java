package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
public class RemarkCommandTut extends Command {
    public static final String COMMAND_WORD = "remarktut";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return new CommandResult("Hello from remarktut");
    }
}
