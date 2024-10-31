package seedu.address.model.volunteer;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import seedu.address.model.exceptions.VolunteerDuplicateDateException;

/**
 * Represents a Event's date in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDate(String)}
 * Throws: DateTimeParseException if an invalid date is provided
 */
public class VolunteerDates {

    public static final String MESSAGE_CONSTRAINTS =
            "Dates should follow the format yyyy-mm-dd, and it should not be blank. Multiple dates in a list should"
                    + "separated by a comma and a space E.g 2022-01-15, 2033-02-17";
    private final ArrayList<LocalDate> dates = new ArrayList<>();
    private final StringProperty datesListAsObservableString = new SimpleStringProperty();

    /**
     * Constructs a {@code Date}.
     *
     * @param listOfDates A valid list of dates.
     */
    public VolunteerDates(String listOfDates) throws DateTimeParseException, VolunteerDuplicateDateException {
        String[] strings = listOfDates.split(", ");
        this.addStringOfDatesToAvailList(strings);
    }

    public StringProperty getDatesListAsObservableString() {
        return this.datesListAsObservableString;
    }

    /**
     * Adds a given string of dates to its list of dates.
     * @param dates
     * @throws DateTimeParseException
     * @throws VolunteerDuplicateDateException
     */
    public void addStringOfDatesToAvailList(String... dates) throws DateTimeParseException,
            VolunteerDuplicateDateException {
        for (String date : dates) {
            requireNonNull(date);
            checkArgument(isValidDate(date), MESSAGE_CONSTRAINTS);
            this.addDateToAvailList(LocalDate.parse(date));
        }
        this.datesListAsObservableString.set(this.toString());
    }

    private void addDateToAvailList(LocalDate date) throws VolunteerDuplicateDateException {
        if (this.dates.contains(date)) {
            throw new VolunteerDuplicateDateException(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        } else {
            this.dates.add(date);
        }
    }

    /**
     * Returns true if a given string is a valid date.
     */
    public static boolean isValidDate(String test) {
        try {
            LocalDate.parse(test);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Returns true if a given string is a valid list of dates.
     * @param test
     * @return
     */
    public static boolean isValidListOfDates(String test) {
        String[] dates = test.split(", ");
        for (String s : dates) {
            if (!isValidDate(s)) {
                return false;
            }
        }
        return true;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (LocalDate d : dates) {
            s.append(d.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            if (dates.indexOf(d) != dates.size() - 1) {
                s.append(", ");
            }
        }
        return s.toString();
    }

    public String toParsableString() {
        return this.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof VolunteerDates)) {
            return false;
        }

        VolunteerDates otherDate = (VolunteerDates) other;
        return dates.equals(otherDate.dates);
    }

    @Override
    public int hashCode() {
        return dates.hashCode();
    }
}
