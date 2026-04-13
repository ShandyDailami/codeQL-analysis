import java.util.HashMap;
import java.util.Map;

public class java_41879_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_41879_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        // Add some default credentials
        this.credentials.put("admin", "password");
    }

    public boolean validate(String user, String password) {
        // For the sake of this example, we'll just check if the password is correct
        return this.credentials.get(user).equals(password);
    }
}