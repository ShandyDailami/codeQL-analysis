public class java_13663_CredentialValidator_A03 {

    // Predefined credentials
    private String correctUsername = "admin";
    private String correctPassword = "password";

    // Current user credentials
    private String enteredUsername;
    private String enteredPassword;

    // Constructor
    public java_13663_CredentialValidator_A03(String enteredUsername, String enteredPassword) {
        this.enteredUsername = enteredUsername;
        this.enteredPassword = enteredPassword;
    }

    // Method to validate user credentials
    public boolean validate() {
        return this.enteredUsername.equals(this.correctUsername) &&
                this.enteredPassword.equals(this.correctPassword);
    }

    // Getters
    public String getEnteredUsername() {
        return enteredUsername;
    }

    public String getEnteredPassword() {
        return enteredPassword;
    }

    // Setters
    public void setEnteredUsername(String enteredUsername) {
        this.enteredUsername = enteredUsername;
    }

    public void setEnteredPassword(String enteredPassword) {
        this.enteredPassword = enteredPassword;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");

        if (validator.validate()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password!");
        }
    }
}