package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String MESSAGE_CONSTRAINTS = "Addresses can take any values, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace (ie start with alphanumeric or #)
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "^[a-zA-Z0-9#].*";

    public final String value;

    /**
     * Constructs an {@code Address}.
     *
     * @param address A valid address.
     */
    public Address(String address) {
        requireNonNull(address);
        checkArgument(isValidAddress(address), MESSAGE_CONSTRAINTS);
        value = address;
    }

    /**
     * Returns true if a given string is a valid address.
     */
    public static boolean isValidAddress(String test) {
        String trimmedInput = test.trim();

        // If input was " ", trimmedInput would be empty ie invalid address
        if (trimmedInput.isEmpty()) {
            return false;
        }

        boolean isAlphanumeric = trimmedInput.matches(".*[a-zA-Z0-9].*");

        return trimmedInput.matches(VALIDATION_REGEX) && isAlphanumeric;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Address)) {
            return false;
        }

        Address otherAddress = (Address) other;
        return value.equals(otherAddress.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
