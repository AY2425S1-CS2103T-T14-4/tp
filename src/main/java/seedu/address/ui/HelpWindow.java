package seedu.address.ui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String USERGUIDE_URL =
            "https://ay2425s1-cs2103t-t14-4.github.io/tp/UserGuide.html#quick-start";
    public static final String HELP_MESSAGE =
            "For more information, please refer to the user guide.";

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private TableView<CommandSummary> commandTable;

    @FXML
    private VBox mainContainer;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        root.setTitle("Help");
        root.getScene().getStylesheets().add("view/css/HelpWindow.css");
        Label titleLabel = new Label("Command Summary");
        titleLabel.getStyleClass().add("help-title");
        mainContainer.getChildren().add(0, titleLabel);
        initializeCommandTable();
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Initializes the command table with predefined columns and items. This method sets up the structure of the table,
     * including the columns for action, command format, and example, and fills it with data.
     */
    private void initializeCommandTable() {
        TableColumn<CommandSummary, String> actionCol = new TableColumn<>("Action");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("action"));
        actionCol.setPrefWidth(200);
        actionCol.setCellFactory(this::createWrappingCell);

        TableColumn<CommandSummary, String> commandFormatCol = new TableColumn<>("Command Format");
        commandFormatCol.setCellValueFactory(new PropertyValueFactory<>("commandFormat"));
        commandFormatCol.setPrefWidth(400);
        commandFormatCol.setCellFactory(this::createWrappingCell);

        TableColumn<CommandSummary, String> exampleCol = new TableColumn<>("Example");
        exampleCol.setCellValueFactory(new PropertyValueFactory<>("example"));
        exampleCol.setPrefWidth(400);
        exampleCol.setCellFactory(this::createWrappingCell);

        commandTable.getColumns().addAll(actionCol, commandFormatCol, exampleCol);

        commandTable.getItems().addAll(
                new CommandSummary("Save Data Automatically",
                        "Automatic",
                        "No command required"),
                new CommandSummary(
                        "Add New Client",
                        "add n/ <NAME> p/ <PHONE> e/ <EMAIL> a/ <ADDRESS> j/ <JOB> i/ <INCOME> "
                                + "[t/ <TIER>] [s/ <STATUS>] [r/ <REMARK>]",
                        "add n/ TAN LESHEW p/ 99007766 e/ mrtan@ntu.sg a/ com3 j/ doctor i/ 99999 "
                                + "t/ gold s/ urgent r/ got anger issue"),
                new CommandSummary("Remove Old Client",
                        "delete <INDEX>",
                        "delete 69"),
                new CommandSummary("Edit Existing Client",
                        "edit <INDEX> n/ <NAME> p/ <PHONE> e/ <EMAIL> a/ <ADDRESS> j/ <JOB> i/ <INCOME> "
                                + "[t/ <TIER>] [s/ <STATUS>]"
                                + "[rn/ <NEW REMARK>] [ra/ <REMARK TO BE APPENDED ONTO EXISTING ONE>]",
                        "edit 69 n/ TAN LESHEW p/ 77337733 e/ mrtan@ntu.sg a/ COM3 j/ doctor i/ 1000000000 "
                                + "ra/ Specialist in eye care"),
                new CommandSummary("Find a Client by Details",
                        "filter <FLAG>/ <FLAG FIELD>",
                        "filter n/ TAN LESHEW"),
                new CommandSummary("Undo Previous Command",
                        "undo",
                        "undo"),
                new CommandSummary("Help",
                        "help",
                        "help"),
                new CommandSummary("Exit",
                        "exit",
                        "exit")
        );

        commandTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    /**
     * Creates a table cell that supports text wrapping. This method is used as a cell factory for table columns
     * to ensure that long text entries are wrapped correctly within the column width.
     *
     * @param column The table column that the cell belongs to, used to bind the wrapping width property.
     * @return A new TableCell configured to wrap text appropriately.
     */
    private TableCell<CommandSummary, String> createWrappingCell(TableColumn<CommandSummary, String> column) {
        return new TableCell<CommandSummary, String>() {
            private Text text;

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setGraphic(null);
                    setText(null);
                } else {
                    if (text == null) {
                        text = new Text();
                        text.wrappingWidthProperty().bind(column.widthProperty().subtract(10));
                        text.setFill(Color.web("#e6e6e6")); // Set text color explicitly
                    }
                    text.setText(item);
                    setGraphic(text);
                }
            }
        };
    }


    /**
     * Shows the help window.
     * @throws IllegalStateException
     *     <ul>
     *         <li>
     *             if this method is called on a thread other than the JavaFX Application Thread.
     *         </li>
     *         <li>
     *             if this method is called during animation or layout processing.
     *         </li>
     *         <li>
     *             if this method is called on the primary stage.
     *         </li>
     *         <li>
     *             if {@code dialogStage} is already showing.
     *         </li>
     *     </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Opens the user guide in the default browser.
     */
    @FXML
    private void openUserGuide() {
        try {
            Desktop.getDesktop().browse(new URI(USERGUIDE_URL));
        } catch (IOException | URISyntaxException e) {
            logger.warning("Error opening user guide: " + e.getMessage());
        }
    }

    /**
     * Constructs an instance of CommandSummary with specified action, command format, and example.
     */
    public static class CommandSummary {
        private final String action;
        private final String commandFormat;
        private final String example;

        /**
         * Constructor for CommandSummary subclass
         */
        public CommandSummary(String action, String commandFormat, String example) {
            this.action = action;
            this.commandFormat = commandFormat;
            this.example = example;
        }

        /**
         * Returns the action part of the command summary.
         *
         * @return A string representing the action.
         */
        public String getAction() {
            return action;
        }

        /**
         * Returns the command format part of the command summary.
         *
         * @return A string representing the command format.
         */
        public String getCommandFormat() {
            return commandFormat;
        }

        /**
         * Returns the example part of the command summary.
         *
         * @return A string representing the example.
         */
        public String getExample() {
            return example;
        }

    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
