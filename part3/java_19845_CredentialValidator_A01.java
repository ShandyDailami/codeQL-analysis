// Import required classes
import java.util.Arrays;
import java.util.Base64;

public class java_19845_CredentialValidator_A01 {

    // Custom Credential Validator
    public boolean validate(String username, String password) {
        // Convert username and password to base64 to bypass direct access
        byte[] decodedBytes = Base64.getDecoder().decode(username + ":" + password);
        String decodedString = new String(decodedBytes);
        
        // Split the decoded string into username and password
        String[] credentials = decodedString.split(":");
        
        // Verify if the username and password match the hard-coded ones
        if (credentials[0].equals("admin") && credentials[1].equals("password")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        System.out.println(validator.validate("dGVzdCBib2R5", "YWRtaW4=")); // True
        System.out.println(validator.validate("dGVzdCBib2R5", "YWRtaW5=")); // False
    }
}