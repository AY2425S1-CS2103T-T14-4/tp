package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.CommandCommons;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Income;
import seedu.address.model.person.Job;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;
import seedu.address.model.status.Status;
import seedu.address.model.tier.Tier;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final String address;
    private final String job;
    private final String incomeString;
    private final String remark;
    private final JsonAdaptedTier assignedTier;
    private final JsonAdaptedStatus assignedStatus;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
                             @JsonProperty("email") String email, @JsonProperty("address") String address,
                             @JsonProperty("job") String job, @JsonProperty("income") String incomeString,
                             @JsonProperty("assignedTier") JsonAdaptedTier assignedTier,
                             @JsonProperty("remark") String remark,
                             @JsonProperty("assignedStatus") JsonAdaptedStatus assignedStatus) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.job = job;
        this.incomeString = incomeString;
        this.assignedTier = assignedTier != null ? assignedTier : new JsonAdaptedTier("");
        this.remark = remark;
        this.assignedStatus = assignedStatus != null ? assignedStatus
                : new JsonAdaptedStatus(CommandCommons.DEFAULT_STATUS);
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        name = source.getName().fullName;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        address = source.getAddress().value;
        job = source.getJob().value;
        incomeString = Integer.toString(source.getIncome().value);
        remark = source.getRemark().value;
        Tier tier = source.getTier();
        assignedTier = tier != null ? new JsonAdaptedTier(tier) : new JsonAdaptedTier("");
        Status status = source.getStatus();
        assignedStatus = status != null ? new JsonAdaptedStatus(status)
                : new JsonAdaptedStatus(CommandCommons.DEFAULT_STATUS);

    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Person toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);

        if (job == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Job.class.getSimpleName()));
        }
        if (!Job.isValidJob(job)) {
            throw new IllegalValueException(Job.MESSAGE_CONSTRAINTS);
        }
        final Job modelJob = new Job(job);

        if (!Income.isValidIncome(incomeString)) {
            throw new IllegalValueException(Income.MESSAGE_CONSTRAINTS);
        }
        final Income modelIncome = new Income(Integer.parseInt(incomeString));

        if (assignedTier == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Tier.class.getSimpleName()));
        }
        final Tier modelTier = assignedTier.toModelType();

        if (remark == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Remark.class.getSimpleName()));
        }
        final Remark modelRemark = new Remark(remark);

        if (assignedStatus == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Status.class.getSimpleName()));
        }
        final Status modelStatus = assignedStatus.toModelType();
        return new Person(modelName, modelPhone, modelEmail, modelAddress, modelJob,
                modelIncome, modelTier, modelRemark, modelStatus);
    }

}
