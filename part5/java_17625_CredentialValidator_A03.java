import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_17625_CredentialValidator_A03 implements javax.security.auth.CredentialValidator {

    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("alice", Base64.getEncoder().encodeToString("alice:alice".getBytes()));
        users.put("bob", Base64.getEncoder().encodeToString("bob:bob".getBytes()));
    }

    @Override
    public String validate(String arg0) throws java.security.AuthException {
        String[] decoded = new String(Base64.getDecoder().decode(arg0), java.nio.charset.StandardCharset.ISO_8859_1);
        String username = decoded[0];
        String password = decoded[1];

        if (username != null && password != null && users.containsKey(username) && users.get(username).equals(password)) {
            return username;
        }
        throw new java.security.AuthException("Invalid username or password");
    }
}