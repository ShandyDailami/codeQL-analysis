public class java_11728_CredentialValidator_A03 {

    // Simplified user database for demonstration purposes
    private static User[] users = {
        new User("user1", "password1", "User 1"),
        new User("user2", "password2", "User 2"),
        new User("user3", "password3", "User 3")
    };

    // User class for demonstration purposes
    private static class User {
        String username;
        String password;
        String name;

        User(String username, String password, String name) {
            this.username = username;
            this.password = password;
            this.name = name;
        }
    }

    // Authenticate method
    public static boolean authenticate(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return true;
            }
        }
        return false;
    }

    // CredentialValidator main method for demonstration purposes
    public static void main(String[] args) {
        if (authenticate("user1", "password1")) {
            System.out.println("User 1 is logged in successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}