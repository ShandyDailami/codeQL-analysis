import java.security.InvalidParameterException;
import java.util.Base64;

public class java_34339_CredentialValidator_A07 {

    public String validate(String user, String password) {
        // For simplicity, let's assume that the user and password are base64 encoded
        byte[] decodedBytes = Base64.getDecoder().decode(user);
        String decodedUser = new String(decodedBytes);

        decodedBytes = Base64.getDecoder().decode(password);
        String decodedPassword = new String(decodedBytes);

        if (decodedUser == null || decodedUser.isEmpty()) {
            throw new InvalidParameterException("Username must not be empty");
        }

        if (decodedPassword == null || decodedPassword.isEmpty()) {
            throw new InvalidParameterException("Password must not be empty");
       
        }
        // Assume that the username and password are valid if they are not empty
        return "Valid credentials";
    }
}