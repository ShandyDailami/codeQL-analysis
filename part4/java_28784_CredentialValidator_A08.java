import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_28784_CredentialValidator_A08 implements javax.security.auth.CredentialValidator {

    private Map<String, String> credentials;

    public java_28784_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        this.credentials.put("username", Base64.getEncoder().encodeToString("user123".getBytes()));
        this.credentials.put("password", Base64.getEncoder().encodeToString("password123".getBytes()));
    }

    @Override
    public String getPassword(String userName) {
        return this.credentials.get(userName);
    }

    @Override
    public String getCallerPrincipal(String userName) {
        return userName;
    }

    @Override
    public boolean validate(String input) throws java.lang.Exception {
        return true;
    }
}