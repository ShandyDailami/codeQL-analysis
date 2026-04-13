// Import required libraries
import java.security.InvalidParameterException;
import java.util.Base64;

public class java_10963_CredentialValidator_A08 {
    // Define Credential
    private String userName;
    private String password;

    // Constructor
    public java_10963_CredentialValidator_A08(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // Validate Credential Method
    public boolean validateCredential() {
        // Base64 decoding
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedString = new String(decodedPassword);

        // Check if password is correct
        if (userName.equals("admin") && decodedString.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            // Create CredentialValidator instance with correct credentials
            CredentialValidator validator = new CredentialValidator("admin", "ZW5jb2RlZCB0ZXh0");

            // Validate Credential
            if (validator.validateCredential()) {
                System.out.println("Access granted!");
            } else {
                System.out.println("Access denied!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}