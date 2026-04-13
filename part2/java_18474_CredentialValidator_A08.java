import java.security.AuthProvider;
import java.security.InvalidParameterException;

public class java_18474_CredentialValidator_A08 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[{]};:',.<>?/\\|`~";
    private static final String NUMBER = "0123456789";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    private boolean authenticated = false;

    public boolean validate(Credential credential) throws InvalidParameterException {
        if (credential.getAuthType() != Credential.PASSWORD_AUTH) {
            throw new InvalidParameterException("Unsupported Authentication Type");
        }

        String password = new String(credential.getCredentials());

        if (!(password.matches("^(?=.*[" + UPPERCASE + "])(?=.*[" + LOWERCASE + "])(?=.*[" + NUMBER + "])(?=.*[" + SPECIAL_CHARACTERS + "])[A-Za-z" + NUMBER + "@$#!%^&*()_=+{}\\[|:;<,>.?/\\\\]].{8,}$"))) {
            throw new InvalidParameterException("Invalid Password");
        }

        authenticated = true;
        return authenticated;
    }
}