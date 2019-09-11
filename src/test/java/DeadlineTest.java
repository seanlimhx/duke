import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    private TaskList tasks;
    private Storage storage;
    @Test
    public void alwaysTrueTest() {
        assertEquals(2, 2);
    }

    @Test
    public void toStringTest() throws DukeException {
        String input = "deadline deadlinetest /by 19/10/1998 1423";
        String[] details = input.split(" ", 4);
        String expectedOutput = "[D][✗]deadlinetest(by: 19 October 1998 Monday, 2:23 PM)";
        Deadline expectedDeadline = new Deadline(details[1], details[3]);
        String actualOutput = expectedDeadline.toString();
        assertEquals(expectedOutput, actualOutput);
    }

}
