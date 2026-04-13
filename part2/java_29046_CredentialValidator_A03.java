import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_29046_CredentialValidator_A03 {

    // Simulate a data source that stores user credentials
    private Map<String, String> userCredentials = new HashMap<>();

    public java_29046_CredentialValidator_A03() {
        userCredentials.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    public boolean validate(String username, String password) {
        String expectedPassword = userCredentials.get(username);
        if (expectedPassword != null) {
            return expectedPassword.equals(Base64.getEncoder().encodeToString(password.getBytes()));
        } else {
            return false;
        }
    }

}