import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_01232_CredentialValidator_A03 implements CallbackHandler {

    private String user;
    private String password;

    public java_01232_CredentialValidator_A03(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(Callback callback) throws LoginException, UnsupportedCallbackException {
        String providedPassword = (String) callback.getCredential().getCredentialIdentifier();

        if (user.equals(providedPassword)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        javax.security.auth.Subject subject = new Subject("realm1");
        subject.getPrincipals().add(new Principal("user"));
        subject.getCredentials().add(new UsernamePasswordCredential("user", "password"));

        CustomCredentialHandler credentialHandler = new CustomCredentialHandler("user", "password");

        try {
            subject. authenticate(credentialHandler);
            System.out.println("Authentication successful!");
        } catch (LoginException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}