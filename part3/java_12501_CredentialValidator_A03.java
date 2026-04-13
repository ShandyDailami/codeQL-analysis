import java.util.HashMap;
import java.util.Map;

public class java_12501_CredentialValidator_A03 {
    private Map<String, String> credentialMap;

    public java_12501_CredentialValidator_A03() {
        this.credentialMap = new HashMap<>();
        this.credentialMap.put("user1", "password1");
        this.credentialMap.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = this.credentialMap.get(username);

        if (expectedPassword == null) {
            System.out.println("No user found with name: " + username);
            return false;
        }

        if (!expectedPassword.equals(password)) {
            System.out.println("Password for user " + username + " does not match");
            return false;
        }

        return true;
    }
}