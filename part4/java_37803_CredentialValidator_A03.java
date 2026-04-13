import java.util.Base64;

public class java_37803_CredentialValidator_A03 {
    // Field for storing the password
    private String password;

    // Constructor for the CredentialValidator
    public java_37803_CredentialValidator_A03(String password) {
        this.password = password;
    }

    // Method for validating the password
    public boolean validatePassword(String password) {
        // Base64 decoding of the password
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedString = new String(decodedPassword);

        // Checking if the decoded password matches the original password
        return decodedString.equals(this.password);
    }

    public static void main(String[] args) {
        // Creating a new CredentialValidator and validating the password
        CredentialValidator validator = new CredentialValidator("password");
        boolean isValid = validator.validatePassword(Base64.getEncoder().encode("password".getBytes()));

        // Printing the result
        if (isValid) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }
}