import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.UsernamePasswordAuthenticationException;
import javax.security.auth.credential.Credential;

public class java_37405_CredentialValidator_A03 implements CredentialValidationResult.Status, CallbackHandler {

    private String username = "test";
    private String password = "test";

    @Override
    public CredentialValidationResult validate(Callback[] callbacks) {
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordAuthenticationToken) {
                UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) callback;
                if (token.getIdentifier().equals(this.username) && token.getCredentials().equals(this.password)) {
                    return CredentialValidationResult.success();
                }
            }
        }
        return CredentialValidationResult.failed();
    }

    public static void main(String[] args) {
        CredentialValidator credentialValidator = new CredentialValidator();
        Credential c = credentialValidator.validate(new Callback[]{new UsernamePasswordAuthenticationToken("test", "test")});
        if (c.getStatus().intValue() == 0) {
            System.out.println("Credentials are valid");
        } else {
            System.out.println("Credentials are invalid");
        }
    }
}