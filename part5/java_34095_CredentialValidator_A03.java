import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_34095_CredentialValidator_A03 {

    private Map<String, String> credentialMap;

    public java_34095_CredentialValidator_A03() {
        this.credentialMap = new HashMap<>();
        this.credentialMap.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentialMap.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentialMap.containsKey(username) && credentialMap.get(username).equals(encodedPassword);
    }
}