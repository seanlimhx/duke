import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void alwaysTrueTest(){
        assertEquals(2, 2);
    }

    @Test
    public void toStringTest(){
        String input = "todo todotest";
        String expectedOutput = "[T][✗]todotest";
        Todo expectedTodo = new Todo(input);
        String actualOutput = expectedTodo.toString();
        assertEquals(expectedOutput, actualOutput);
    }
}