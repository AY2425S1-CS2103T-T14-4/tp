package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.AddressBook;
import seedu.address.testutil.TypicalEvents;
import seedu.address.testutil.TypicalVolunteers;

public class JsonSerializableAddressBookTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableAddressBookTest");
    private static final Path TYPICAL_PERSONS_FILE = TEST_DATA_FOLDER.resolve("typicalPersonsAddressBook.json");
    private static final Path INVALID_PERSON_FILE = TEST_DATA_FOLDER.resolve("invalidPersonAddressBook.json");
    private static final Path DUPLICATE_PERSON_FILE = TEST_DATA_FOLDER.resolve("duplicatePersonAddressBook.json");
    private static final Path TYPICAL_EVENT_FILE = TEST_DATA_FOLDER.resolve("typicalEventAddressBook.json");
    private static final Path INVALID_EVENT_FILE = TEST_DATA_FOLDER.resolve("invalidEventAddressBook.json");
    private static final Path DUPLICATE_EVENT_FILE = TEST_DATA_FOLDER.resolve("duplicateEventAddressBook.json");
    @Test
    public void toModelType_invalidVolunteerFile_returnsEmptyAddressBook() {
        try {
            JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(INVALID_PERSON_FILE,
                    JsonSerializableAddressBook.class).get();
            assertDoesNotThrow(dataFromFile::toModelType);
            AddressBook emptyFile = new AddressBook();
            assertEquals(emptyFile, dataFromFile.toModelType());
        } catch (DataLoadingException e) {
            throw new AssertionError("DataLoadingException should not have been thrown.");
        }
    }
    @Test
    public void toModelType_typicalPersonsFile_success() throws Exception {
        try {
            JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(TYPICAL_PERSONS_FILE,
                    JsonSerializableAddressBook.class).get();
            AddressBook addressBookFromFile = dataFromFile.toModelType();
            AddressBook typicalPersonsAddressBook = TypicalVolunteers.getTypicalAddressBook();
            assertEquals(addressBookFromFile, typicalPersonsAddressBook);
        } catch (DataLoadingException e) {
            throw new AssertionError("DataLoadingException should not have been thrown.");
        }
    }

    @Test
    public void toModelType_duplicatePersons_throwsIllegalValueException() {
        try {
            JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(DUPLICATE_PERSON_FILE,
                    JsonSerializableAddressBook.class).get();
            assertDoesNotThrow(dataFromFile::toModelType);
        } catch (DataLoadingException e) {
            throw new AssertionError("DataLoadingException should not have been thrown.");
        }
    }

    @Test
    public void toModelType_invalidEventFile_returnsEmptyAddressBook() {
        try {
            JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(INVALID_EVENT_FILE,
                    JsonSerializableAddressBook.class).get();
            assertDoesNotThrow(dataFromFile::toModelType);
            AddressBook emptyFile = new AddressBook();
            assertEquals(emptyFile, dataFromFile.toModelType());
        } catch (DataLoadingException e) {
            throw new AssertionError("DataLoadingException should not have been thrown.");
        }
    }
    @Test
    public void toModelType_typicalEventFile_success() {
        try {
            JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(TYPICAL_EVENT_FILE,
                    JsonSerializableAddressBook.class).get();
            AddressBook addressBookFromFile = dataFromFile.toModelType();
            AddressBook typicalPersonsAddressBook = TypicalEvents.getTypicalAddressBook();
            assertEquals(addressBookFromFile, typicalPersonsAddressBook);
        } catch (DataLoadingException e) {
            throw new AssertionError("DataLoadingException should not have been thrown.");
        }
    }

    @Test
    public void toModelType_duplicateEvent_throwsIllegalValueException() {
        try {
            JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(DUPLICATE_EVENT_FILE,
                    JsonSerializableAddressBook.class).get();
            assertDoesNotThrow(dataFromFile::toModelType);
        } catch (DataLoadingException e) {
            throw new AssertionError("DataLoadingException should not have been thrown.");
        }
    }

}
