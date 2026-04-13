import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.security.AccessControlException;
import java.util.Arrays;

public class java_08584_CredentialValidator_A08 implements CallbackHandler {
    private static final String[] PRINCIPALS = {"User1", "User2"};
    private static final String[] CREDENTIALS = {"password1", "password2"};
    private static final String[] AUTHZID = {"group1", "group2"};

    public static void main(String[] args) throws Exception {
        CustomCredential cc = new CustomCredential();
        Subject.login(cc);
    }

    @Override
    public boolean handle(Callback callback) throws java.io.IOException, LoginException {
        if (!(callback instanceof CallbackHandler.CallbackResult)) {
            throw new IllegalArgumentException("Unsupported callback: " + callback.getClass().getName());
        }
        CallbackResult cr = (CallbackResult) callback;

        // prompt for password
        PasswordCallback pc = new PasswordCallback() {
            @Override
            public void setPassword(String password) {
                // do nothing
            }

            @Override
            public String getPassword() {
                return password;
            }
        };

        cr.setCallback(pc);
        cr.setPrompt("Enter password");

        // request password
        cr.invoke();

        String enteredPassword = pc.getPassword();
        if (enteredPassword == null) {
            throw new LoginException("Login failed");
        }

        if (!Arrays.equals(enteredPassword, passwords(pc.getPromptAlias()))) {
            throw new AccessControlException("Access denied");
        }

        cr.setSuccess(new CallbackResult[] { cr });
        return true;
    }

    private char[] passwords(String s) throws IllegalArgumentException {
        // simulate the generation of passwords
        if (s == null || s.length() != 1) {
            throw new IllegalArgumentException("null or too long string");
        }
        return new char[]{s.charAt(0)};
    }
}