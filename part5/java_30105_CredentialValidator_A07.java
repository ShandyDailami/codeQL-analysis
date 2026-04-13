import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;
import java.util.HashMap;
import java.util.Map;

public class java_30105_CredentialValidator_A07 implements CredentialValidator {

    private static final Map<String, String> userMap = new HashMap<>();

    static {
        userMap.put("alice", "password1");
        userMap.put("bob", "password2");
        userMap.put("charlie", "password3");
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String username = credential.getIdentifier();
        String password = credential.getCredential();

        return userMap.containsKey(username) && userMap.get(username).equals(password);
    }
}