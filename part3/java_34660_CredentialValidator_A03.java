import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_34660_CredentialValidator_A03 {

    private Map<String, String> credentialMap;

    public java_34660_CredentialValidator_A03() {
        credentialMap = new HashMap<>();
        credentialMap.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentialMap.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentialMap.get(username) != null && encodedPassword.equals(credentialMap.get(username));
    }
}