import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_04537_CredentialValidator_A07 implements CredentialValidator {
    private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("alice", Base64.getEncoder().encodeToString("alice:password".getBytes()));
        credentials.put("bob", Base64.getEncoder().encodeToString("bob:password".getBytes()));
    }

    @Override
    public boolean validate(String user, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.get(user).equals(encodedPassword);
    }
}