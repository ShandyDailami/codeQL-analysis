import java.util.Base64;

public class java_17914_CredentialValidator_A01 {

    // Decodes the credential (e.g., a username/password pair) and validates it
    public boolean validateCredentials(String credential) {
        // Decode the credential
        byte[] decodedCredential = Base64.getDecoder().decode(credential);
        String decodedString = new String(decodedCredential);

        // Split the decoded string into username and password
        String[] decodedArray = decodedString.split(":");
        String username = decodedArray[0];
        String password = decodedArray[1];

        // Here you would normally connect to a database or other secure storage
        // to check if the username and password match a record in the database
        // This is a simplification, in a real-world application you would need to connect
        // to a database, not just store and check records in a string

        String databaseUsername = "admin";
        String databasePassword = "password";

        // Check if the username and password match
        if (username.equals(databaseUsername) && password.equals(databasePassword)) {
            return true;
        } else {
            return false;
        }
    }
}