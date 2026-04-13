import java.util.HashMap;
import java.util.Map;

public class java_16298_CredentialValidator_A01 implements CredentialValidator {
    private Map<String, String> userCredentials;

    public java_16298_CredentialValidator_A01() {
        userCredentials = new HashMap<>();
        userCredentials.put("admin", "password");
    }

    @Override
    public boolean validate(String username, String password) {
        if(userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            System.out.println("Access granted for user: " + username);
            return true;
        } else {
            System.out.println("Access denied for user: " + username);
            return false;
        }
    }
}

public interface CredentialValidator {
    boolean validate(String username, String password);
}