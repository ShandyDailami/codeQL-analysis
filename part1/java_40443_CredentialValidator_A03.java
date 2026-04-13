import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_40443_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_40443_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }
        this.credentials.put(username, password);
    }

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }
        return this.credentials.containsKey(username) && this.credentials.get(username).equals(password);
    }
}