package seedu.addressbook.data.person;

public class Contact {

    public static String EXAMPLE;
    public static String MESSAGE_CONSTRAINTS;
    public static String VALIDATION_REGEX;

    public String value;
    protected boolean isPrivate;

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
