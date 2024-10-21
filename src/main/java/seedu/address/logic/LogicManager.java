package seedu.address.logic;

import static seedu.address.logic.Messages.MESSAGE_COMMAND_CANCELLED;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.AddressBookParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Person;
import seedu.address.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_FORMAT = "Could not save data due to the following error: %s";

    public static final String FILE_OPS_PERMISSION_ERROR_FORMAT =
            "Could not save data to file %s due to insufficient permissions to write to the file or the folder.";

    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final AddressBookParser addressBookParser;

    // Boolean to determine if user has confirmed they want to delete command
    private boolean awaitingConfirmation = false;
    private Command delayedCommand = null;

    /**
     * Constructs a {@code LogicManager} with the given {@code Model} and {@code Storage}.
     */
    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        addressBookParser = new AddressBookParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        if (this.awaitingConfirmation) {
            commandResult = handleConfirmation(commandText);
        } else {
            Command command = addressBookParser.parseCommand(commandText);
            commandResult = command.execute(model, this.awaitingConfirmation);

            if (commandResult.isShowConfirmation() && !this.awaitingConfirmation) {
                this.awaitingConfirmation = true;
                this.delayedCommand = command;
            }
        }

        try {
            storage.saveAddressBook(model.getAddressBook());
        } catch (AccessDeniedException e) {
            throw new CommandException(String.format(FILE_OPS_PERMISSION_ERROR_FORMAT, e.getMessage()), e);
        } catch (IOException ioe) {
            throw new CommandException(String.format(FILE_OPS_ERROR_FORMAT, ioe.getMessage()), ioe);
        }

        return commandResult;
    }

    /**
     * Processes user input for command confirmation.
     * Executes the delayed command if confirmed, or cancels it and returns a cancellation message.
     *
     * @param commandText The user's confirmation input.
     * @return The result of the command if confirmed, or a cancellation message.
     * @throws CommandException If an error occurs during command execution.
     */
    private CommandResult handleConfirmation(String commandText) throws CommandException {
        CommandResult commandResult;
        if (addressBookParser.parseConfirmation(commandText)) {
            commandResult = this.delayedCommand.execute(model, this.awaitingConfirmation);
        } else {
            commandResult = new CommandResult(MESSAGE_COMMAND_CANCELLED);
        }
        this.awaitingConfirmation = false;
        return commandResult;
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return model.getAddressBook();
    }

    @Override
    public ObservableList<Person> getFilteredPersonList() {
        return model.getFilteredPersonList();
    }

    @Override
    public Path getAddressBookFilePath() {
        return model.getAddressBookFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }
}
