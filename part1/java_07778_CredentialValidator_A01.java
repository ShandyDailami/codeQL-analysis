import java.util.HashMap;
import java.util.Map;

public interface CredentialValidator {
    Map<String, String> validate(Credential credential);
}

public class java_07778_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_07778_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class Credential {
    private String username;
    private String password;

    public java_07778_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class SecureCredentialValidator implements CredentialValidator {
    private Map<String, String> predefinedCredentials;

    public java_07778_CredentialValidator_A01() {
        this.predefinedCredentials = new HashMap<>();
        predefinedCredentials.put("user1", "password1");
        predefinedCredentials.put("user2", "password2");
    }

    public Map<String, String> validate(Credential credential) {
        Map<String, String> result = new HashMap<>();
        if (credential.getUsername().equals(predefinedCredentials.get(credential.getUsername())) 
                && credential.getPassword().equals(predefinedCredentials.get(credential.getPassword()))) {
            result.put("status", "success");
        } else {
            result.put("status", "failure");
        }
        return result;
    }
}