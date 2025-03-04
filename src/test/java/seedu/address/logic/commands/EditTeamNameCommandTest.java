package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
import static seedu.address.testutil.TypicalTeams.getTypicalTeamBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;


public class EditTeamNameCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), getTypicalTeamBook(), new UserPrefs());

    @Test
    public void execute_duplicateTeamName_throwsCommandException() {
        String originalTeamName = "TEAM1";
        String newTeamName = "TEAM1";

        EditTeamNameCommand editTeamNameCommand = new EditTeamNameCommand(originalTeamName, newTeamName);

        assertCommandFailure(editTeamNameCommand, model, EditTeamNameCommand.MESSAGE_DUPLICATE_TEAM_NAME);
    }

    @Test
    public void toString_correctStringRepresentation() {
        String originalTeamName = "TEAM1";
        String newTeamName = "Beta team";
        EditTeamNameCommand editTeamNameCommand = new EditTeamNameCommand(originalTeamName, newTeamName);

        String expectedString = "seedu.address.logic.commands.EditTeamNameCommand{"
                + "Original Team Name=TEAM1, New Team Name=Beta team}";

        assertEquals(expectedString, editTeamNameCommand.toString());
    }


    @Test
    public void equals() {
        final EditTeamNameCommand standardCommand = new EditTeamNameCommand("Alpha team", "Beta team");

        // same values -> returns true
        EditTeamNameCommand commandWithSameValues = new EditTeamNameCommand("Alpha team", "Beta team");
        assertEquals(standardCommand, commandWithSameValues);

        // same object -> returns true
        assertEquals(standardCommand, standardCommand);

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different team name -> returns false
        assertFalse(standardCommand.equals(new EditTeamNameCommand("Beta team", "Gamma team")));
    }
}
