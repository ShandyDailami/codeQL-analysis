public class java_22241_CredentialValidator_A01 {
    private String expectedUsername;
    private String expectedPassword;

    public java_22241_CredentialValidator_A01(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    public boolean isValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
            return true;
        }

        return false;
    }
}

public class User {
    private String username;
    private String password;

    public java_22241_CredentialValidator_A01(String username, String password) {
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

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        User user = new User("admin", "password");

        if (validator.isValid(user.getUsername(), user.getPassword())) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}