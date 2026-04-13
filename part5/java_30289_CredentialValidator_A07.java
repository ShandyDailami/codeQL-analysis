import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.usernamepassword.UsernamePasswordCredential;
import javax.security.auth.validate.ValidationResult;

public class java_30289_CredentialValidator_A07 implements CredentialValidationResult.Status, CallbackHandler {

    private String expectedUsername = "user";
    private String expectedPassword = "password";

    public CredentialValidationResult validate(CallbackHandler callbackHandler) throws UnsupportedCallbackException {
        Callback callback = callbackHandler.getCallback();

        // Validate username
        String username = (String) callback.getParameter("username");
        if (!this.expectedUsername.equals(username)) {
            return new CredentialValidationResult(this.Status.FAILURE, null);
        }

        // Validate password
        String password = (String) callback.getParameter("password");
        if (!this.expectedPassword.equals(password)) {
            return new CredentialValidationResult(this.Status.FAILURE, null);
        }

        return new CredentialValidationResult(this.Status.SUCCESS, null);
    }

    public static void main(String[] args) {
        HardCodedCredentialValidator credentialValidator = new HardCodedCredentialValidator();
        CredentialValidationResult result = credentialValidator.validate(null);
        if (result.getStatus() == CredentialValidationResult.Status.SUCCESS) {
            System.out.println("Authentication succeeded!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}