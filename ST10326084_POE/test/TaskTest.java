import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest { // (Coding with John, 2022)
    private String[] taskNames;
    private String[] developerNames;
    private float[] taskDurations;
    private String[] taskStatuses;

    @BeforeEach
    public void setUp() { // (Coding with John, 2022)
        // Populate the arrays with test data
        taskNames = new String[] {"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
        developerNames = new String[] {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        taskDurations = new float[] {5, 8, 2, 11};
        taskStatuses = new String[] {"To Do", "Doing", "Done", "To Do"};
    }

    @Test
    public void testDeveloperArrayPopulatedCorrectly() { // (Coding with John, 2022)
        // Test that the developer array contains the expected test data
        assertArrayEquals(new String[] {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"}, developerNames);
    }

    @Test
    public void testDisplayDeveloperAndDurationForLongestDurationTask() { // (Coding with John, 2022)
        // Test displaying the developer and duration for the task with the longest duration
        Task.displayTaskWithLongestDuration();
        // Perform assertions or manual checks to verify the output
    }

    @Test
    public void testSearchForTaskByName() { // (Coding with John, 2022)
        // Test searching for a task by name
        String expectedOutput = "Mike Smith, Create Login";
        
        Task task = new Task();
        String actualOutput = task.searchTaskByName("Create Login"); // (Coding with John, 2022)
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSearchTasksByDeveloper() { // (Coding with John, 2022)
        // Test searching for tasks assigned to a developer
        String expectedOutput = "Create Reports";
        String actualOutput = Task.searchTasksByDeveloper("Samantha Paulson");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDeleteTaskByName() { // (Coding with John, 2022)
        // Test deleting a task by name
        String taskNameToDelete = "Create Reports";
        Task.deleteTaskByName(taskNameToDelete);
        // Perform assertions or manual checks to verify that the task was successfully deleted
    }

    @Test
    public void testDisplayReport() { // (Coding with John, 2022)
        // Test displaying the full report
        Task.displayAllTasks();
        // Perform assertions or manual checks to verify the output
    }

    @Test
    public void testOptionAddTasks() { // (Coding with John, 2022)
        // Test adding tasks using the optionAddTasks method
        // Prepare test data for a new task
        String name = "Mike Smith";
        String surname = "Smith";
        int tasks = 1;
        Task.optionAddTasks(name, surname, tasks);

        // Perform assertions or manual checks to verify that the task was added correctly
    }

    @Test
    public void testCheckTaskDescription() { // (Coding with John, 2022)
        // Test the checkTaskDescription method
        String validDescription = "Valid task description";
        String invalidDescription = "This is a very long task description that exceeds the limit of 50 characters";

        // Test a valid task description
        assertTrue(Task.checkTaskDescription(validDescription));

        // Test an invalid task description
        assertFalse(Task.checkTaskDescription(invalidDescription));
    }

    @Test
    public void testReturnTotalHours() { // (Coding with John, 2022)
        // Test the returnTotalHours method
        String validHours = "5.5";
        String invalidHours = "Invalid hours";

        // Test a valid input
        assertEquals(5.5f, Task.returnTotalHours(validHours));

        // Test an invalid input
        assertThrows(NumberFormatException.class, () -> Task.returnTotalHours(invalidHours));
    }

    @Test
    public void testGetTaskStatus() { // (Coding with John, 2022)
        // Test the getTaskStatus method
        // You can either test the user input using JOptionPane.showOptionDialog or refactor the method to accept a parameter and test that directly
        // Perform assertions or manual checks to verify the returned task status
    }

    @Test
    public void testCreateTaskID() { // (Coding with John, 2022)
        // Test the createTaskID method
        // Prepare test data for task ID creation
        String taskName = "Test Task";
        int index = 1;
        String surname = "Doe";

        // Call the createTaskID method with the test data
        String taskID = Task.createTaskID(taskName, index, surname);

        // Perform assertions or manual checks to verify the generated task ID
    }
}
