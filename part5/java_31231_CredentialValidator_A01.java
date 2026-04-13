import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.LoginException;

public class java_31231_CredentialValidator_A01 implements CallbackHandler {

    private static final String EXPECTED_USERNAME = "testUser";
    private static final String EXPECTED_PASSWORD = "testPassword";

    @Override
    public UsernamePasswordAuthenticationToken getCallBack(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordAuthenticationToken) {
                return (UsernamePasswordAuthenticationToken) callback;
            }
        }
        throw new UnsupportedCallbackException(callbacks);
    }

    @Override
    public UsernamePasswordAuthenticationToken validate(CallbackHandler callbackHandler) throws LoginException {
        UsernamePasswordAuthenticationToken callback = callbackHandler.getCallBack(callbacks);

        String username = callback.getIdentifier();
        char[] password = callback.getPassword();

        if (!username.equals(EXPECTED_USERNAME) || !isExpectedPassword(password)) {
            throw new LoginException("Invalid Credentials");
        }

        return new UsernamePasswordAuthenticationToken(username, password, null);
    }

    private boolean isExpectedPassword(char[] password) {
        // Here you can implement password comparison logic, e.g., compare the password with a hashed one
        // This is a simple example, you should implement your own logic
        for (char c : password) {
            if (c != EXPECTED_PASSWORD.charAt(password.length - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Here you can test your CredentialValidator, e.g.,
        CredentialValidator validator = new CredentialValidator();
        UsernamePasswordAuthenticationToken token = validator.validate(validator);
        if (token != null) {
            System.out.println("Valid credentials!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}