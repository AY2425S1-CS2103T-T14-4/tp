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
    private FlowPane assignedStatus;
    @FXML
    private FlowPane assignedStatusAndTier;
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
        phone.setText("Phone:", person.getPhone().value);
        address.setText("Address:", person.getAddress().value);
        email.setText("Email:", person.getEmail().value);
        job.setText("Job:", person.getJob().value);
        income.setText("Income:", person.getIncome().toString());
        remark.setText(person.getRemark().value);
        cardFields.getChildren().addAll(phone, address, email, job, income);
    }

    private void createTier() {
        // Create a label for the tier
        Label tierLabel = new Label(person.getTier().toParsableString());

        // Apply a different style class based on the tier value
        String tier = person.getTier().toParsableString().toUpperCase();
        switch (tier) {
        case "GOLD" -> tierLabel.getStyleClass().add("gold-tier");
        case "SILVER" -> tierLabel.getStyleClass().add("silver-tier");
        case "BRONZE" -> tierLabel.getStyleClass().add("bronze-tier");
        case "REJECT" -> tierLabel.getStyleClass().add("reject-tier");
        default -> tierLabel = null;
        }
        if (tierLabel != null) {
            // Add the label to the FlowPane
            assignedStatusAndTier.getChildren().add(tierLabel);
        }
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
            assignedStatusAndTier.getChildren().add(statusLabel);

        }
    }
}
