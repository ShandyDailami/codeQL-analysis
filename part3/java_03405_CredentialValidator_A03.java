import java.util.Base64;

public class java_03405_CredentialValidator_A03 {

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        String hardcodedCredentials = "username:password";
        String hardcodedPassword = "password";

        // Decode the hardcoded credentials
        byte[] decodedCredentials = Base64.getDecoder().decode(hardcodedCredentials);
        String decodedUsernamePassword = new String(decodedCredentials, "UTF-8");

        // Check if the username and password match the hardcoded value
        return decodedUsernamePassword.equals(username + ":" + password);
    }
}