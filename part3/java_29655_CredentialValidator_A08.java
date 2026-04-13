import javax.security.auth.CredentialValidationResult;
import javax.security.auth.PasswordValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;

public class java_29655_CredentialValidator_A08 implements CredentialValidationResult.Level, CredentialValidationResult, CallbackHandler {

    private static final long serialVersionUID = 1L;

    @Override
    public CredentialValidationResult validate(Callback[] callbacks) {
        PasswordValidationResult passwordResult = null;
        if (callbacks != null && callbacks.length > 0) {
            for (Callback callback : callbacks) {
                if (callback instanceof PasswordValidationResult) {
                    passwordResult = (PasswordValidationResult) callback;
                }
            }
        }

        if (passwordResult == null) {
            passwordResult = new PasswordValidationResult("Invalid password or null credentials", PasswordValidationResult. Level.ERROR);
            return passwordResult;
        }

        if (!passwordResult.isValid()) {
            return passwordResult;
        }

        String password = passwordResult.getPassword();

        boolean upperCase = false, lowerCase = false, digit = false, specialChars = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCase = true;
            } else if (Character.isLowerCase(c)) {
                lowerCase = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            } else if (!"%$#@&*".contains(c + "")) {
                specialChars = true;
            }

            if (upperCase && lowerCase && digit && specialChars) {
                return new PasswordValidationResult(password, Level.OK);
            }
        }

        return new PasswordValidationResult(password, Level.ERROR);
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        // TODO Auto-generated method stub
    }

}