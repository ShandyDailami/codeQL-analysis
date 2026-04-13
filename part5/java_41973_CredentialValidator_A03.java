import java.util.HashMap;
import java.util.Map;

public class java_41973_CredentialValidator_A03 implements CredentialValidator {

    private Map<String, String> validCredentials;

    public java_41973_CredentialValidator_A03() {
        validCredentials = new HashMap<>();
        validCredentials.put("user1", "password1");
        validCredentials.put("user2", "password2");
        validCredentials.put("user3", "password3");
    }

    @Override
    public boolean validate(String username, String password) {
        return validCredentials.containsKey(username) && validCredentials.get(username).equals(password);
    }
}

interface CredentialValidator {
    boolean validate(String username, String password);
}