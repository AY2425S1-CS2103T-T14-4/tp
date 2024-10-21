package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.status.Status;

/**
 * Jackson-friendly version of {@link Status}.
 */
class JsonAdaptedStatus {

    private final String status;

    /**
     * Constructs a {@code JsonAdaptedTag} with the given {@code status}.
     */
    @JsonCreator
    public JsonAdaptedStatus(String status) {
        this.status = status;
    }

    /**
     * Converts a given {@code Tier} into this class for Jackson use.
     */
    public JsonAdaptedStatus(Status source) {
        status = source.toParsableString();
    }

    @JsonValue
    public String getStatusName() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }

    /**
     * Converts this Jackson-friendly adapted tier object into the model's {@code Status} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted Status.
     */
    public Status toModelType() throws IllegalValueException {
        if (!Status.isValidStatus(status)) {
            throw new IllegalValueException(Status.MESSAGE_CONSTRAINTS);
        }
        return new Status(status);
    }
}
