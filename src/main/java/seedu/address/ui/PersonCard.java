package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.model.person.Person;
import seedu.address.model.status.Status;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    private PersonCardField phone = new PersonCardField();
    private PersonCardField address = new PersonCardField();
    private PersonCardField job = new PersonCardField();
    private PersonCardField email = new PersonCardField();
    private PersonCardField income = new PersonCardField();
    @FXML
    private Label remark;
    @FXML
    private FlowPane assignedTier;
    @FXML
    private FlowPane assignedStatus;
    @FXML
    private VBox cardFields;
    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        createFields();
        createStatus();
        createTier();
    }
    private void createFields() {
        name.setText(person.getName().fullName);
        phone.setFields(PersonCardField.ICON_LITERAL_PHONE, person.getPhone().value);
        address.setFields(PersonCardField.ICON_LITERAL_ADDRESS, person.getAddress().value);
        email.setFields(PersonCardField.ICON_LITERAL_EMAIL, person.getEmail().value);
        job.setFields(PersonCardField.ICON_LITERAL_JOB, person.getJob().value);
        income.setFields(PersonCardField.ICON_LITERAL_INCOME, person.getIncome().toString());
        remark.setText(person.getRemark().value);
        cardFields.getChildren().addAll(phone, address, email, job, income);
    }

    private void createTier() {
        // Create a label for the tier
        Label tierLabel = new Label(person.getTier().toParsableString().toUpperCase());

        // Apply the existing style classes
        tierLabel.getStyleClass().add("label");

        // Add the tier-specific style class
        String tier = person.getTier().toParsableString().toLowerCase();
        tierLabel.getStyleClass().add(tier + "-tier");

        // Add the label to the FlowPane
        assignedTier.getChildren().add(tierLabel);
    }

    private void createStatus() {
        Label statusLabel = new Label(person.getStatus().toParsableString());

        // Apply a different style class based on the status value
        Status.StatusEnum status = person.getStatus().status;
        switch (status) {
        case NONE -> statusLabel.getStyleClass().add("none-status");
        case NON_URGENT -> statusLabel.getStyleClass().add("nonUrgent-status");
        case URGENT -> statusLabel.getStyleClass().add("urgent-status");
        default -> statusLabel = null;
        }
        if (statusLabel != null) {
            assignedStatus.getChildren().add(statusLabel);

        }
    }
}
