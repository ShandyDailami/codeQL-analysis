public class java_20751_CredentialValidator_A01 {
    public static void main(String[] args) {
        User user = new User("user1", "password1");

        if (validateCredentials(user, "wrongPassword")) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }

    private static boolean validateCredentials(User user, String password) {
        // No external dependencies, only standard Java libraries

        // Check if the user's password matches the provided password
        return user.getPassword().equals(password);
    }
}

class User {
    private String username;
    private String password;

    public java_20751_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}