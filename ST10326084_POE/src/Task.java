import javax.swing.JOptionPane;

public class Task {
   //(W3schools.com, 2023)
    private static String[] taskNames;
    private static String[] taskDescriptions;
    private static float[] taskDurations;
    private static String[] developerNames;
    private static String[] taskStatuses;
    private static String[] taskIDs;
    private static int numTasks = 0;
    private static int totalHours = 0;

    public static void runTaskManagement(String name, String surname) { // (W3schools.com, 2023)
        int choice;
        do {
            choice = showMenu();
            JOptionPane.showMessageDialog(null, "\nLoading System: " + choice);
            // (Tutorialspoint.com, 2020)
            
            if (choice == 1) {
                optionAddTasks(name, surname);
            } else if (choice == 2) {
                optionShowReport();
            } else {
                JOptionPane.showMessageDialog(null, "Exiting System...");
            }
        } while (choice != 3);
    }
    // (W3schools.com, 2023)
    public static int showMenu() { // (W3schools.com, 2023)
        int choice = 0;
        try {
            String menuMessage = "\tMenu:\n\n"
                    + "============================================================\n"
                    + "\t1. Option 1 - Add Tasks\n"
                    + "\t2. Option 2 - Show Report\n"
                    + "\t3. Option 3 - Exit\n"
                    + "============================================================\n"
                    + "Enter your choice:";
            String choiceString = JOptionPane.showInputDialog(null, menuMessage);
            choice = Integer.parseInt(choiceString);
            if (choice < 1 || choice > 3) {
                JOptionPane.showMessageDialog(null, "Invalid option. Enter a number from 1 to 3.");
                choice = 0;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid option. Enter a number from 1 to 3.");
            choice = 0;
        }
        return choice;
    }

    public static void optionAddTasks(String name, String surname) {
        int tasks = Integer.parseInt(JOptionPane.showInputDialog(null, "How many tasks do you want to add?"));
        // (W3schools.com, 2023)
        taskNames = new String[tasks];
        taskDescriptions = new String[tasks];
        taskDurations = new float[tasks];
        developerNames = new String[tasks];
        taskStatuses = new String[tasks];
        taskIDs = new String[tasks];

        for (int i = 0; i < tasks; i++) { // (W3schools.com, 2023)
            JOptionPane.showMessageDialog(null, "Option 1 - Add Tasks");

            String taskName = JOptionPane.showInputDialog(null, "Enter the task name:");
            taskNames[i] = taskName;

            while (true) {
                String taskDescription = JOptionPane.showInputDialog(null,
                        "Enter the task's description (50 or fewer characters):");
                if (checkTaskDescription(taskDescription)) {
                    taskDescriptions[i] = taskDescription;
                    JOptionPane.showMessageDialog(null, "Task successfully captured.");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of 50 or fewer characters.");
                }
            }

            float taskDuration = returnTotalHours();
            taskDurations[i] = taskDuration;
            totalHours += taskDuration;

            String taskStatus = getTaskStatus();
            taskStatuses[i] = taskStatus;

            String taskID = createTaskID(taskName, i, surname);
            taskIDs[i] = taskID;
            developerNames[i] = name + " " + surname;

            numTasks++;
        }
    }

    public static boolean checkTaskDescription(String description) {
        return description.length() <= 50;
   }

    public static float returnTotalHours() {
        float totalHours = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                String hoursString = JOptionPane.showInputDialog(null, "Enter the task duration in hours:");
                totalHours = Float.parseFloat(hoursString);
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }
        return totalHours;
    }
    // simple get status method (W3schools.com, 2023)
    public static String getTaskStatus() {
        String[] options = { "To Do", "In Progress", "Done" };
        int statusIndex = JOptionPane.showOptionDialog(null, "Select the task status:", "Task Status",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String taskStatus = options[statusIndex];
        return taskStatus;
    }
    // create task id using name, number etc
    public static String createTaskID(String taskName, int index, String surname) {
        String initials = taskName.substring(0, 2).toUpperCase();
        String id = initials + index + surname.substring(0, 2).toUpperCase();
        return id;
    }
    // choice 2  (W3schools.com, 2023)
    public static void optionShowReport() {
        JOptionPane.showMessageDialog(null, "Option 2 - Report");

        if (numTasks > 0) {
            String reportString = JOptionPane.showInputDialog(null,
                    "Select an option:\n\n" +
                    "1. Display the Developer, Task Names, Task Duration, and Task ID for all tasks with the status 'Done'\n" +
                    "2. Display the Developer and Duration of the task with the longest duration\n" +
                    "3. Search for a task by Task Name and display the Task Name, Developer, Task Status, and Task ID\n" +
                    "4. Search for all tasks assigned to a developer and display the Task Name, Task Status, and Task ID\n" +
                    "5. Delete a task using the Task Name\n" +
                    "6. Display a report that lists the full details of all captured tasks");

            int reportMenu = Integer.parseInt(reportString);

            if (reportMenu == 1) {
                displayTasksWithStatus("Done");
            } else if (reportMenu == 2) {
                displayTaskWithLongestDuration();
            } else if (reportMenu == 3) {
                searchTaskByName();
            } else if (reportMenu == 4) {
                searchTasksByDeveloper();
            } else if (reportMenu == 5) {
                deleteTaskByName();
            } else if (reportMenu == 6) {
                displayAllTasks();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tasks added yet.");
        }
    }
    // option 1 (W3schools.com, 2023)
    public static void displayTasksWithStatus(String status) {
        JOptionPane.showMessageDialog(null, "Tasks with status '" + status + "':");
        boolean foundTasks = false;
        for (int i = 0; i < numTasks; i++) {
            if (taskStatuses[i].equalsIgnoreCase(status)) {
                foundTasks = true;
                printTaskDetails(i);
            }
        }
        if (!foundTasks) {
            JOptionPane.showMessageDialog(null, "No tasks with status '" + status + "' found.");
        }
    }
    // option 2 (W3schools.com, 2023)
    public static void displayTaskWithLongestDuration() {
        float longestDuration = -1;
        int longestDurationIndex = -1;
        for (int i = 0; i < numTasks; i++) {
            if (taskDurations[i] > longestDuration) {
                longestDuration = taskDurations[i];
                longestDurationIndex = i;
            }
        }
        if (longestDurationIndex != -1) {
            JOptionPane.showMessageDialog(null, "Task with longest duration:\n" +
                    "Developer: " + developerNames[longestDurationIndex] + "\n" +
                    "Duration: " + taskDurations[longestDurationIndex] + " hours\n" +
                    "Task ID: " + taskIDs[longestDurationIndex]);
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found.");
        }
    }
    // option 3  (W3schools.com, 2023)
    public static void searchTaskByName() {
        String taskName = JOptionPane.showInputDialog(null, "Enter the task name:");
        boolean foundTask = false;
        for (int i = 0; i < numTasks; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                foundTask = true;
                printTaskDetails(i);
            }
        }
        if (!foundTask) {
            JOptionPane.showMessageDialog(null, "Task '" + taskName + "' not found.");
        }
    }
    // option 4
    public static void searchTasksByDeveloper() {
        String developer = JOptionPane.showInputDialog(null, "Enter the developer's name:");
        boolean foundTasks = false;
        for (int i = 0; i < numTasks; i++) {
            if (developerNames[i].equalsIgnoreCase(developer)) {
                foundTasks = true;
                printTaskDetails(i);
            }
        }
        if (!foundTasks) {
            JOptionPane.showMessageDialog(null, "No tasks assigned to developer '" + developer + "' found.");
        }
    }
    // option 5 (W3schools.com, 2023)
    public static void deleteTaskByName() {
        String taskName = JOptionPane.showInputDialog(null, "Enter the task name:");
        boolean deleted = false;
        for (int i = 0; i < numTasks; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                deleted = true;
                shiftTasksLeft(i);
                numTasks--;
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' deleted.");
                break;
            }
        }
        if (!deleted) {
            JOptionPane.showMessageDialog(null, "Task '" + taskName + "' not found.");
        }
    }
    // sub method for deleteTaskByName()
    public static void shiftTasksLeft(int index) {
        for (int i = index; i < numTasks - 1; i++) {
            taskNames[i] = taskNames[i + 1];
            taskDescriptions[i] = taskDescriptions[i + 1];
            taskDurations[i] = taskDurations[i + 1];
            developerNames[i] = developerNames[i + 1];
            taskStatuses[i] = taskStatuses[i + 1];
            taskIDs[i] = taskIDs[i + 1];
        }
    }
    // option 6
    public static void displayAllTasks() {
        for (int i = 0; i < numTasks; i++) {
            JOptionPane.showMessageDialog(null, "Task " + (i + 1) + " Details:\n");
            printTaskDetails(i);
        }
    }

    public static void printTaskDetails(int index) {
        JOptionPane.showMessageDialog(null,
                "Task Name: " + taskNames[index] + "\n" +
                "Task Description: " + taskDescriptions[index] + "\n" +
                "Task Duration: " + taskDurations[index] + " hours\n" +
                "Developer: " + developerNames[index] + "\n" +
                "Task Status: " + taskStatuses[index] + "\n" +
                "Task ID: " + taskIDs[index]);
    }
}

/**
 * W3schools.com. (2023). Java Tutorial. [online] Available at: https://www.w3schools.com/java/default.asp [Accessed 7 Jul. 2023].
 * W3schools.com. 2023. Java Methods. [online] Available at: https://www.w3schools.com/java/java_methods.asp [Accessed 7 Jul. 2023].
 * W3schools.com. 2023. Java Arrays. [online] Available at: https://www.w3schools.com/java/java_arrays.asp [Accessed 7 Jul. 2023].
 * Tutorialspoint.com. 2020. What are the different types of JOptionPane dialogs in Java. [online] Available at: https://www.tutorialspoint.com/what-are-the-different-types-of-joptionpane-dialogs-in-java#:~:text=The%20JOptionPane%20is%20a%20subclass,the%20complexity%20of%20the%20code. [Accessed 7 Jul. 2023].
‌**/
