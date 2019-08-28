package command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

import java.util.stream.Stream;

/**
 * Command to find tasks which contains given expression.
 *
 */
public class FindCommand extends Command {
    private String expr;

    public FindCommand(String expr) {
        this.expr = expr;
    }

    @Override
    public void execute(TaskList tasklist, Ui ui, Storage storage) throws DukeException {
        Stream<String> taskStream = tasklist
                .getList()
                .stream()
                .filter(task -> task.toString().contains(this.expr))
                .map(task -> task.toString());
        Stream<String> combined = Stream.concat(Stream.of("Here are the matching tasks in your list:"), taskStream);
        String[] combinedString = combined.toArray(String[]::new);
        ui.printStatement(combinedString);
    }
}