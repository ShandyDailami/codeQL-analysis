import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_05917_CredentialValidator_A01 implements CredentialValidator {

    private List<String> allowedUsers = Arrays.asList("user1", "user2", "user3");
    private List<String> allowedPasswords = Arrays.asList("password1", "password2", "password3");

    @Override
    public String validate(String arg0) throws CredentialException, InvalidCredentialException {
        String[] credentials = arg0.split(":");
        if (allowedUsers.contains(credentials[0]) && allowedPasswords.contains(credentials[1])) {
            return arg0;
        } else {
            throw new InvalidCredentialException("Invalid username or password");
        }
    }

    @Override
    public boolean validate(String[] arg0) throws CredentialException, InvalidCredentialException {
        return validate(arg0[0] + ":" + arg0[1]);
    }

    @Override
    public boolean getRequestedCredentialSize() {
        return 2;
    }

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public String getNormantedHost() {
        return null;
    }

    @Override
    public List<String> getAcceptedPasswordInfo() {
        return null;
    }

    @Override
    public boolean supportsQuestionBasedAuthentication() {
        return false;
    }

    @Override
    public boolean supportsUpgradeToQuestionBasedAuthentication() {
        return false;
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        String user = "user1";
        String password = "password1";
        String credential = user + ":" + password;

        try {
            validator.validate(credential.getBytes());
            System.out.println("Credentials are valid.");
        } catch (InvalidCredentialException e) {
            System.out.println("Invalid credentials.");
        }
    }
}