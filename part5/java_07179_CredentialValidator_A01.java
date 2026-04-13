import java.util.HashSet;
import java.util.Set;

public class java_07179_CredentialValidator_A01 {
    // Set of pre-defined credentials
    private Set<String> predefinedCredentials = new HashSet<>();

    public java_07179_CredentialValidator_A01() {
        predefinedCredentials.add("admin");
        predefinedCredentials.add("user");
    }

    public boolean validateCredentials(String username, String password) {
        // Matching credentials
        if (username != null && password != null && predefinedCredentials.contains(username) && password.equals("password")) {
            return true;
        // Mismatching credentials
        } else if (username == null || password == null) {
            return false;
        // Missing credentials
        } else if (username != null && predefinedCredentials.contains(username)) {
            return false;
        } else {
            return false;
        }
    }
}