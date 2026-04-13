import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_30747_CredentialValidator_A03 implements CredentialValidator {

    private Map<String, String> userCredentials = new HashMap<>();

    public java_30747_CredentialValidator_A03() {
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public boolean validate(String username, String password) {
        if (userCredentials.containsKey(username)) {
            if (userCredentials.get(username).equals(Base64.getEncoder().encodeToString(password.getBytes()))) {
                return true;
            }
        }
        return false;
    }
}