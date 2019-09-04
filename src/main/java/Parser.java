public class Parser {

    public static Command parse(String fullCommand) throws DukeException{
        String[] details = fullCommand.split(" ", 2);
        Task task = new Task(details[0]);
        Command command = null;
        switch (details[0]) {
            case "list":
                command = new ListCommand(details[0]);
                break;
            case "done":
                Command Command = new DoneCommand(details[1]);
                break;
            case "delete":
                command = new DeleteCommand(details[1]);
                break;
            case "find":
                command = new FindCommand(details[1]);
                break;
            case "todo":
                command = new AddCommand(details[0], details[1]);
                break;
            case "deadline":
                command = new AddCommand(details[0], details[1]);
                break;
            case "event":
                command = new AddCommand(details[0], details[1]);
                break;
            default:
                //System.out.println("dukeexception triggered");
                throw new DukeException(fullCommand);
        }
        return command;
    }

}
