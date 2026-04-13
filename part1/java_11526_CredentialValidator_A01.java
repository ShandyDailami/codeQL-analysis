import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_11526_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_11526_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validate(String username, String password) throws InvalidParameterException {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        String expectedPassword = this.credentials.get(username);

        if (expectedPassword == null) {
            throw new InvalidParameterException("Invalid username");
        }

        return expectedPassword.equals(password);
    }
}