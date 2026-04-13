import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;

public class java_27260_CredentialValidator_A03 {

    // Use a HashMap to store users and their passwords.
    private static Map<String, String> userDatabase = new HashMap<>();

    // The constructor of the CustomValidator class.
    public java_27260_CredentialValidator_A03() {
        // Initialize userDatabase.
        userDatabase.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userDatabase.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    // The method to validate credentials.
    public boolean validate(String username, String password) {
        // Check if the user exists in the database.
        if (userDatabase.containsKey(username)) {
            // Decode the password from Base64.
            byte[] decodedPassword = Base64.getDecoder().decode(userDatabase.get(username));
            // Convert the password into a String.
            String decodedPasswordString = new String(decodedPassword);
            // Compare the entered password with the password in the database.
            if (password.equals(decodedPasswordString)) {
                return true;
            }
        }
        return false;
    }

    // The main method to test the CustomValidator.
    public static void main(String[] args) {
        // Create a new instance of the CustomValidator.
        CustomValidator validator = new CustomValidator();
        // Create credentials.
        Credential credential = new UsernamePasswordCredential("user1", "password1".getBytes());
        try {
            // Validate the credentials.
            System.out.println(validator.validate(credential.getUsername(), new String(credential.getPassword())));
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}