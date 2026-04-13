import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.security.AccessControlException;
import java.security.auth.Subject;
import java.security.auth.callback.CallbackQuery;
import java.security.credential.Credential;
import java.util.Arrays;

public class java_07443_CredentialValidator_A07 implements CredentialValidator {
    private String user;
    private String password;

    public java_07443_CredentialValidator_A07(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) {
        String inputUser = credential.getID();
        char[] inputPassword = credential.getPassword();

        if (user.equals(inputUser) && Arrays.equals(password.toCharArray(), inputPassword)) {
            return CredentialValidationResult.VALID;
        } else {
            return CredentialValidationResult.INVALID;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator credentialValidator = new CustomCredentialValidator("user", "password");
        System.out.println(credentialValidator.validate(null, null));
    }
}