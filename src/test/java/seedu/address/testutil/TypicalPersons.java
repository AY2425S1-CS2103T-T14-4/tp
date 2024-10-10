package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TIER_REJECT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final String EMPTY_REMARK = "";
    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253").withJob("Engineer")
            .withIncome(3)
            ..withTiers("GOLD").withRemark("She is stingy").build();
    public static final Person BENSON = new PersonBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withIncome(40).withJob("Doctor")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withTiers("Bronze").withRemark("He is rich").build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("wall street").withJob("Lawyer")
            .withIncome(40)
            .withRemark(EMPTY_REMARK).build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street").withJob("Artist")
            .withIncome(30)
            .withTiers("REJECT")
            .withRemark(EMPTY_REMARK).build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("94822240")
            .withEmail("werner@example.com").withAddress("michegan ave").withJob("Nurse")
            .withIncome(20)
            .withRemark(EMPTY_REMARK).build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("94824271")
            .withEmail("lydia@example.com").withAddress("little tokyo").withJob("Chef")
            .withIncome(45)
            .withRemark("Rich japanese person").build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best").withPhone("94823442")
            .withEmail("anna@example.com").withAddress("4th street").withJob("Teacher")
            .withIncome(50)
            .withRemark(EMPTY_REMARK).build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withPhone("84824234")
            .withEmail("stefan@example.com").withAddress("little india").withJob("Architect")
            .withIncome(40)
            .withRemark(EMPTY_REMARK).build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withPhone("84822131")
            .withEmail("hans@example.com").withAddress("chicago ave").withJob("Writer")
            .withIncome(50)
            .withRemark(EMPTY_REMARK).build();
    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).
            .withJob("Teacher")
            .withIncome(999999999)
            .withTiers(VALID_TIER_REJECT)
            .withRemark(EMPTY_REMARK).build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withJob("Developer")
            .withIncome(9)
            .withTiers(VALID_TIER_REJECT)
            .withRemark(EMPTY_REMARK).build();

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }

}