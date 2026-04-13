import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_27007_CredentialValidator_A01 implements CallbackHandler {

    private static final Set<String> ALLOWED_USERNAMES = new HashSet<>(Arrays.asList("user1", "user2", "admin"));
    private static final Set<char[]> ALLOWED_PASSWORDS = new HashSet<>();

    static {
        char[] password1 = "password1".toCharArray();
        char[] password2 = "password2".toCharArray();
        ALLOWED_PASSWORDS.add(password1);
        ALLOWED_PASSWORDS.add(password2);
    }

    @Override
    public boolean handle(Callback[] callbacks) throws IOException, LoginException {
        UsernamePasswordCallback callback = (UsernamePasswordCallback) callbacks[0];

        if (ALLOWED_USERNAMES.contains(callback.getIdentifier())) {
            callback.setPassword(getPassword(callback.getIdentifier()));
            return true;
        }

        return false;
    }

    private char[] getPassword(String username) {
        // This is a placeholder. In a real application, you would likely fetch the password from a database or some other secure source.
        if (ALLOWED_USERNAMES.contains(username)) {
            return ALLOWED_PASSWORDS.iterator().next();
        }
        return new char[0];
    }

    public static void main(String[] args) {
        Subject subject = new Subject.PublicKeySubject("id");
        CustomCredentialValidator validator = new CustomCredentialValidator();
        subject.getPublicKey().setKey(null);
        subject.setCallbackHandler(validator);
        subject.authenticate(null);
    }
}