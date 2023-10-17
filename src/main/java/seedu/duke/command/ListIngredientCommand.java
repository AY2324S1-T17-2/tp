package seedu.duke.command;

import seedu.duke.data.Menu;
import seedu.duke.data.dish.Dish;
import seedu.duke.data.dish.Ingredient;
import seedu.duke.ui.Ui;

/**
 * Lists all ingredients used in the selected dish to the user.
 */
public class ListIngredientCommand extends Command {
    public static final String COMMAND_WORD = "list_ingredients";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Lists out the ingredients needed along with the quantity for a specific dish.\n"
            + "Parameters: INDEX\n"
            + "Example: " + COMMAND_WORD + " 1";

    public ListIngredientCommand(int listIndex){
        this.index = listIndex;
    }

    @Override
    public void execute(Menu menu, Ui ui) {
        Dish selectedDish = menu.getMenuItemsList().get(index - Ui.OFFSET_LIST_INDEX);
        if (selectedDish != null) {
            ui.printIngredients(selectedDish);
        } else {
            ui.showToUser("Please select a valid dish index :)");
        }
    }
}
