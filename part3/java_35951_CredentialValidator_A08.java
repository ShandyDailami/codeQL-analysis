public class java_35951_CredentialValidator_A08 {
    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // The actual username and password provided by the user
    private String enteredUsername;
    private String enteredPassword;

    // Constructor
    public java_35951_CredentialValidator_A08(String enteredUsername, String enteredPassword) {
        this.enteredUsername = enteredUsername;
        this.enteredPassword = enteredPassword;
    }

    // Method to validate the credentials
    public boolean validate() {
        return (enteredUsername.equals(USERNAME) && enteredPassword.equals(PASSWORD));
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.validate()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}