import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_34611_CredentialValidator_A01 {
    // hardcoded username and password for demonstration purposes
    private static final Map<String, String> hardcodedCredentials = new HashMap<String, String>() {
        {
            put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
        }
    };

    public boolean isValid(String username, String password) {
        // decode the password
        String decodedPassword = new String(Base64.getDecoder().decode(hardcodedCredentials.get(username)));

        // compare the decoded password with the provided password
        return password.equals(decodedPassword);
    }
}