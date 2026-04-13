import java.security.Principal;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_16733_CredentialValidator_A07 {

    private Map<String, String> credentialMap;

    public java_16733_CredentialValidator_A07() {
        this.credentialMap = new HashMap<>();
        //Adding some example credentials
        credentialMap.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentialMap.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean isValid(Principal principal, String passwordAttempt) {
        if (principal == null || passwordAttempt == null) {
            return false;
        }

        String encodedPassword = Base64.getEncoder().encodeToString(passwordAttempt.getBytes());
        String storedPassword = credentialMap.get(principal.getName());

        if (storedPassword == null) {
            return false;
        }

        return storedPassword.equals(encodedPassword);
    }
}