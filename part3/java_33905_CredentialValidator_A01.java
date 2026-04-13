import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_33905_CredentialValidator_A01 {

    private Map<String, String> credentialsMap;

    public java_33905_CredentialValidator_A01() {
        credentialsMap = new HashMap<>();
        credentialsMap.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentialsMap.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentialsMap.get(user).equals(encodedPassword);
    }
}