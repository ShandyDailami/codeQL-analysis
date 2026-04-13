import java.util.Base64;

public class java_31228_CredentialValidator_A01 {
    // a method to validate the password
    public boolean validatePassword(String password) {
        // here we assume that password is always encoded in base64.
        // in a real application, you should use a more secure way to handle passwords.
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        String decodedPassword = new String(decodedBytes);
        
        // for simplicity, let's say the password is 'password'
        if (decodedPassword.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    // a method to validate the username
    public boolean validateUsername(String username) {
        // for simplicity, let's say the username is 'admin'
        if (username.equals("admin")) {
            return true;
        } else {
            return false;
        }
    }

    // a method to validate both username and password
    public boolean validateCredentials(String username, String password) {
        if (validateUsername(username) && validatePassword(password)) {
            return true;
        } else {
            return false;
        }
    }
}