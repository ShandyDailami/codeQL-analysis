import java.util.HashMap;
import java.util.Map;

public class java_24266_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentialsMap;

    public java_24266_CredentialValidator_A07() {
        // initialize the credentials map
        credentialsMap = new HashMap<>();
        credentialsMap.put("user1", "password1");
        credentialsMap.put("user2", "password2");
    }

    @Override
    public boolean validate(String userName, String password) {
        // validate the user's credentials
        if (credentialsMap.containsKey(userName) && credentialsMap.get(userName).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}