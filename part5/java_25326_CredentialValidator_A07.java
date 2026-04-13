public class java_25326_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_25326_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // hardcoded username and password
        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        if (this.username.equals(hardcodedUsername) && this.password.equals(hardcodedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new CredentialValidator with a hardcoded username and password
        CredentialValidator validator = new CredentialValidator("admin", "password");

        // Validate the CredentialValidator
        if (validator.validate()) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}