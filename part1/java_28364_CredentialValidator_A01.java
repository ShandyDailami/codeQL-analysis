public class java_28364_CredentialValidator_A01 {
    // Private field to store the password
    private String password;

    // Constructor
    public java_28364_CredentialValidator_A01(String password) {
        this.password = password;
    }

    // Method to validate if the provided password is correct
    public boolean validate(String providedPassword) {
        // If the provided password is null, return false
        if (providedPassword == null) {
            return false;
        }
        
        // Check if the provided password matches the saved password
        return providedPassword.equals(this.password);
    }
}