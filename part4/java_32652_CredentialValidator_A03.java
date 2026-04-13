import java.security.Principal;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class java_32652_CredentialValidator_A03 {

    // Define a set of hardcoded credentials
    private static final Set<String> hardcodedCredentials = new HashSet<String>() {{
        add("user:password");
        add("admin:admin");
    }};

    // CredentialValidator method
    public boolean validateCredentials(Principal principal, String username, String password) {
        // Base64 decode the username and password
        String decodedUsername = new String(Base64.getDecoder().decode(username));
        String decodedPassword = new String(Base64.getDecoder().decode(password));

        // Check if the decoded credentials match the hardcoded credentials
        return hardcodedCredentials.contains(decodedUsername + ":" + decodedPassword);
    }

}