import java.util.Base64;

public class java_07191_CredentialValidator_A03 {

    // Method to validate credentials
    public boolean validateCredentials(String userName, String password) {
        // Storing the user name and password in Base64 format
        String usernameAndPassword = userName + ":" + password;

        // Encoding the user name and password
        String encodedCredentials = new String(Base64.getEncoder().encode(usernameAndPassword.getBytes()));

        // If the encoded credentials equals to "YWJjZGVmZw==", it means the credentials are valid
        if (encodedCredentials.equals("YWJjZGVmZw==")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validateCredentials("admin", "password")); // Outputs: false
    }
}