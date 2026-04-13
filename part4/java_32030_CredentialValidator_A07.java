import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class java_32030_CredentialValidator_A07 {

    private static final Set<String> ALLOWED_USERS = new HashSet<>(Arrays.asList("user1", "user2", "user3"));
    private static final Set<String> ALLOWED_ROLES = new HashSet<>(Arrays.asList("role1", "role2", "role3"));

    public boolean validate(Credential credential) {
        String username = credential.getIdentifier();
        String password = new String(credential.getCredentialIdentifier(), "UTF-8");

        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordStr = new String(decodedPassword, "UTF-8");

        if (!ALLOWED_USERS.contains(username) || !ALLOWED_ROLES.contains(decodedPasswordStr)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Credential credential = new UsernamePasswordCredential("user1", "password");

        CustomCredentialValidator validator = new CustomCredentialValidator();
        boolean isValid = validator.validate(credential);

        System.out.println("Is valid: " + isValid);
    }
}