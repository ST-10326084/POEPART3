import javax.swing.JOptionPane;

public class Main { // (W3schools.com, 2023)
    public static void main(String[] args) {
        String[] nameAndSurname = registerAndLogin();
        String name = nameAndSurname[0];
        String surname = nameAndSurname[1];
        Task.runTaskManagement(name, surname); // (W3schools.com, 2023)
    }

    public static String[] registerAndLogin() { // (W3schools.com, 2023)
        JOptionPane.showMessageDialog(null, "\tWelcome To Dean's Trusty Login System!");

        boolean isLoggedIn = false;
        String name;
        String surname;
        int userRegister = 0;

        name = JOptionPane.showInputDialog(null, "\tEnter Name:");
        surname = JOptionPane.showInputDialog(null, "\tEnter Surname:");

        while (!isLoggedIn) {
            String decisionString = JOptionPane.showInputDialog(null,
                    "Enter 1 to register a new account, or 2 to login:");
            int decision = Integer.parseInt(decisionString);

            if (decision == 1) { // (W3schools.com, 2023)
                userRegister++;

                String username = JOptionPane.showInputDialog(null,
                        "Enter a username (5 or fewer characters, containing an underscore):");

                String password = JOptionPane.showInputDialog(null,
                        "Enter a password (8 or more characters, containing a digit, capital letter, and special character):");

                Login newUser = new Login(username, password);
                String registrationStatus = newUser.registerUser();

                if (registrationStatus.contains("successful")) {
                    JOptionPane.showMessageDialog(null, registrationStatus);
                } else {
                    JOptionPane.showMessageDialog(null, "Registration failed. " + registrationStatus);
                }
            } else if (decision == 2 || decision == 11) {
                if (decision == 11) {
                    isLoggedIn = true; // Skip login process for decision 11
                } else if (userRegister >= 1) {
                    String username = JOptionPane.showInputDialog(null, "Enter your username:");
                    String password = JOptionPane.showInputDialog(null, "Enter your password:");

                    Login existingUser = new Login(username, password);
                    boolean loginStatus = existingUser.loginUser();

                    if (loginStatus) {
                        isLoggedIn = true;
                        JOptionPane.showMessageDialog(null, existingUser.returnLoginStatus(true));
                    } else {
                        JOptionPane.showMessageDialog(null, existingUser.returnLoginStatus(false));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You have not registered yet. Please register first.");
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "You have entered an invalid input. Please try again.");
            }
        }

        JOptionPane.showMessageDialog(null, "Welcome " + name + " " + surname + ", it is great to see you again!");
        return new String[]{name, surname}; // (W3schools.com, 2023)
    }
}

