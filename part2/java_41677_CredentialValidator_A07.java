public class java_41677_CredentialValidator_A07 {

    private String expectedUsername;
    private String expectedPassword;

    public java_41677_CredentialValidator_A07(String username, String password) {
        this.expectedUsername = username;
        this.expectedPassword = password;
    }

    public boolean validate(String username, String password) {
        if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
            System.out.println("Authentication successful!");
            return true;
        } else {
            System.out.println("Authentication failed!");
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");

        validator.validate("admin", "password"); // Authentication successful
        validator.validate("user", "wrong_password"); // Authentication failed
    }
}