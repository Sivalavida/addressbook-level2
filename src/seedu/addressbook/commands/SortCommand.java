package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Sorts by name and lists all persons in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book, sorted by name, as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = new ArrayList<>(addressBook.getAllPersons().immutableListView());
        Comparator<ReadOnlyPerson> nameComparator = new Comparator<ReadOnlyPerson>() {
            @Override
            public int compare(ReadOnlyPerson person, ReadOnlyPerson otherPerson) {
                String name = person.getName().toString();
                String otherName = otherPerson.getName().toString();
                return name.compareTo(otherName);
            }
        };
        allPersons.sort(nameComparator);
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}

