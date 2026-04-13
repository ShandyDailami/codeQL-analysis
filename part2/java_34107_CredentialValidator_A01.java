import java.util.Base64;

public class java_34107_CredentialValidator_A01 {

    // Private method to decode the encoded credentials
    private String decodeCredentials(String encodedCredentials) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        return new String(decodedBytes);
    }

    // Public method to validate the credentials
    public boolean validateCredentials(String userName, String password, String encodedCredentials) {
        String userPass = userName + ":" + password;
        String decodedCredentials = decodeCredentials(encodedCredentials);
        
        // If the decoded credentials match the userPass, return true
        return decodedCredentials.equals(userPass);
    }
}