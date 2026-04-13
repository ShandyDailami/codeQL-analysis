// User class java_09506_CredentialValidator_A03 class User {
    private String username;
    private String password;

    public CredentialValidator(String username, String password) {
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

// CredentialValidator class
public class CredentialValidator {
    private User[] users;

    public CredentialValidator() {
        users = new User[1];
        users[0] = new User("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "admin";
        String password = "password";

        if (validator.validateCredentials(username, password)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}