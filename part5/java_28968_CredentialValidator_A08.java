import java.util.HashMap;
import java.util.Map;

public class java_28968_CredentialValidator_A08 implements CredentialValidator {

    private Map<String, String> credentialStore;

    public java_28968_CredentialValidator_A08() {
        credentialStore = new HashMap<>();
    }

    public void addUserCredentials(String username, String password) {
        credentialStore.put(username, password);
    }

    @Override
    public boolean validate(String username, String password) {
        if (credentialStore.containsKey(username) &&
            credentialStore.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}