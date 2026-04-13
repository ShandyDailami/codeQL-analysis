public class java_33378_CredentialValidator_A01 {

    // Fields
    private String password;
    private String encryptedPassword;

    // Constructor
    public java_33378_CredentialValidator_A01(String password) {
        this.password = password;
        this.encryptedPassword = encryptPassword(password);
    }

    // Method to encrypt password
    private String encryptPassword(String password) {
        // This is a simplistic encryption method
        // It would be more complicated if we were using a secure hash function
        // But for the sake of simplicity, we'll just use a simple XOR operation
        StringBuilder encryptedPassword = new StringBuilder();
        for (char c : password.toCharArray()) {
            encryptedPassword.append((char) (c ^ 'A'));
        }
        return encryptedPassword.toString();
    }

    // Method to validate the password
    public boolean validatePassword(String enteredPassword) {
        // Simple check for a case-sensitive password comparison
        // This could be more complex if we wanted to check for password strength, etc.
        return enteredPassword.equals(encryptPassword(enteredPassword));
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("password");
        System.out.println(validator.validatePassword("password")); // Outputs: true
        System.out.println(validator.validatePassword("wrongpassword")); // Outputs: false
    }
}