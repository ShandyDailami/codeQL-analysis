import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_29458_CredentialValidator_A01 {
    private Map<String, String> users;

    public java_29458_CredentialValidator_A01() {
        users = new HashMap<>();
        users.put("admin", Base64.getEncoder().encodeToString("password".getBytes())); // We'll store passwords in Base64 for simplicity
    }

    public boolean validate(String username, String password) throws InvalidParameterException {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password cannot be null");
        }

        String hashedPassword = users.get(username);

        if (hashedPassword == null) {
            throw new InvalidParameterException("Invalid username");
        }

        // We compare the hashed passwords using a simple comparison. In a real-world scenario,
        // you'd probably use a more secure way of comparing hashed passwords.
        byte[] hashedInput = hashedPassword.getBytes();
        byte[] suppliedInput = password.getBytes();
        int result = new String(hashedInput).compareTo(new String(suppliedInput));

        if (result == 0) {
            return true;
        } else {
            return false;
        }
    }
}