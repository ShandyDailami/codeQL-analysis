import java.security.Security;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.security.auth.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_12731_CredentialValidator_A07 implements LoginModule {

    private CopyOnWriteArrayList<String> failedLogins = new CopyOnWriteArrayList<>();
    private int failedAttempts = 0;
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final int ATTEMPTS_TIME_INTERVAL = 60;

    @Override
    public String getName() {
        return "Custom Credential Validator";
    }

    @Override
    public void initialize(InputStream paramInputStream, Info paramInfo) throws LoginException {
        // No initialization necessary for this module
    }

    @Override
    public boolean validate(Credential paramCredential) throws LoginException {
        String username = paramCredential.getIdentifier();

        // Check for failed attempts
        if (failedLogins.contains(username)) {
            failedAttempts++;
            if (failedAttempts >= MAX_FAILED_ATTEMPTS || System.currentTimeMillis() - failedLogins.get(failedLogins.indexOf(username)) > ATTEMPTS_TIME_INTERVAL) {
                failedAttempts = 0;
                failedLogins.clear();
                System.out.println("Account locked out due to too many failed attempts. Please try again later.");
                return false;
            }
            System.out.println("Too many failed attempts. Please try again later.");
            return false;
        }

        // Check for brute force protection
        if (Security.getAuthenticationAuthority() != null && Security.getAuthenticationAuthority().getContext() != null) {
            if (Security.getAuthenticationAuthority().getContext().getAttributes().containsKey("brute-force-attempts")) {
                int attempts = (int) Security.getAuthenticationAuthority().getContext().getAttributes().get("brute-force-attempts");
                if (attempts > 0 && attempts >= MAX_FAILED_ATTEMPTS) {
                    System.out.println("Account locked out due to too many failed attempts. Please try again later.");
                    return false;
                }
            }
        }

        // Check for timing attacks
        // For simplicity, we just check if the username is the same as the password
        if (!username.equals(paramCredential.getCredential())) {
            System.out.println("Invalid username or password.");
            return false;
        }

        failedAttempts = 0;
        failedLogins.clear();
        return true;
    }
}