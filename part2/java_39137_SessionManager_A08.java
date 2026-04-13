public class java_39137_SessionManager_A08 {

    // User database. In a real system, this would be from a database.
    private static User[] users = new User[10];

    // Simple user class.
    public static class User {
        public String username;
        public String password;
    }

    // Main method.
    public static void main(String[] args) {

        // Populate user database.
        for (int i = 0; i < 10; i++) {
            users[i] = new User();
            users[i].username = "user" + i;
            users[i].password = "password" + i;
        }

        // Login loop.
        while (true) {
            System.out.print("Enter username: ");
            String username = System.console().readLine();

            System.out.print("Enter password: ");
            String password = System.console().readLine();

            // Attempt login.
            if (login(username, password)) {
                System.out.println("Access granted.");
                break;
            } else {
                System.out.println("Access denied.");
            }
        }
    }

    // Attempt login.
    private static boolean login(String username, String password) {
        // For security reasons, we are not actually comparing the passwords here.
        // In a real system, this would be hashed and compared.

        // Check username and password.
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return true;
            }
        }

        return false;
    }
}