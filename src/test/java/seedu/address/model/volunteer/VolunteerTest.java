package seedu.address.model.volunteer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalVolunteers.ALICE;
import static seedu.address.testutil.TypicalVolunteers.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.VolunteerBuilder;

public class VolunteerTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Volunteer volunteer = new VolunteerBuilder().build();
        if (volunteer.getInvolvedIn().isEmpty()) {
            assertTrue(volunteer.getInvolvedIn().isEmpty());
        } else {
            assertThrows(UnsupportedOperationException.class, () -> volunteer.getEvents().remove(0));
        }
    }

    @Test
    public void isSameVolunteer() {
        // same object -> returns true
        assertTrue(ALICE.isSameVolunteer(ALICE));

        // null -> returns false
        assertFalse(ALICE.isSameVolunteer(null));

        // same name, all other attributes different -> returns true
        Volunteer editedAlice = new VolunteerBuilder(ALICE).withPhone("87654321").withEmail("alice@example.com")
                .withAvailableDate("2023-12-12")
                .build();
        assertTrue(ALICE.isSameVolunteer(editedAlice));

        // different name, all other attributes same -> returns false
        Volunteer editedAliceWithDifferentName = new VolunteerBuilder(ALICE).withName("Alice Ong").build();
        assertFalse(ALICE.isSameVolunteer(editedAliceWithDifferentName));

        // name differs in case, all other attributes same -> returns false
        Volunteer editedBob = new VolunteerBuilder(BOB).withName("bob tan").build();
        assertFalse(BOB.isSameVolunteer(editedBob));

        // name has trailing spaces, all other attributes same -> returns false
        Volunteer editedBobWithTrailingSpaces = new VolunteerBuilder(BOB).withName("Bob Tan ").build();
        assertFalse(BOB.isSameVolunteer(editedBobWithTrailingSpaces));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Volunteer aliceCopy = new VolunteerBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different volunteer (same name, different other attributes) -> returns false
        Volunteer editedAlice = new VolunteerBuilder(ALICE).withPhone("87654321").build();
        assertFalse(ALICE.equals(editedAlice)); // The phone number is different, so it should return false.

        // same attributes except email -> returns false
        Volunteer editedAliceWithDifferentEmail = new VolunteerBuilder(ALICE).withEmail("jane@example.com").build();
        assertFalse(ALICE.equals(editedAliceWithDifferentEmail)); // Email is different, so it should return false.

        // same attributes except available date -> returns false
        Volunteer editedAliceWithDifferentAvailableDate = new VolunteerBuilder(ALICE).withAvailableDate("2024-12-31")
                .build();
        assertFalse(ALICE.equals(editedAliceWithDifferentAvailableDate));

        // completely different volunteer -> returns false
        assertFalse(ALICE.equals(BOB));

        // only name differs -> returns false
        Volunteer editedAliceWithDifferentName = new VolunteerBuilder(ALICE).withName("Jane").build();
        assertFalse(ALICE.equals(editedAliceWithDifferentName));
    }


    @Test
    public void toStringMethod() {
        String expected = "Volunteer{name=" + ALICE.getName()
                + ", phone=" + ALICE.getPhone()
                + ", email=" + ALICE.getEmail()
                + ", availableDate=" + ALICE.getAvailableDate() + "}";
        assertEquals(expected, ALICE.toString());
    }
}
