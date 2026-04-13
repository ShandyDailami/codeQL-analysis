import javax.naming.AuthenticationException;
import javax.security.auth.Subject;
import javax.security.auth.password.PasswordAuthenticator;
import javax.security.auth.password.PasswordChangeException;
import javax.security.auth.password.PasswordStorage;
import javax.security.auth.password.PasswordValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class java_37149_CredentialValidator_A03 implements CredentialValidator {

    private static final String EXPECTED_USER = "test";
    private static final String EXPECTED_PASSWORD = "test";

    @Override
    public boolean validate(Subject subject, Object credentials, Set<String> groups) throws AuthenticationException {
        String user = (String) credentials;
        String password = (String) credentials;

        return Arrays.asList(EXPECTED_USER, EXPECTED_PASSWORD).containsAll(Arrays.asList(user, password));
    }

    @Override
    public boolean validate(Subject subject, Object credentials, Set<String> groups, PasswordAuthenticator passwordAuthenticator) throws AuthenticationException {
        return validate(subject, credentials, groups);
    }

    @Override
    public boolean validate(Subject subject, Object credentials, Set<String> groups, PasswordStorage passwordStorage) throws AuthenticationException {
        return validate(subject, credentials, groups);
    }

    @Override
    public boolean validate(Subject subject, Object credentials, Set<String> groups, PasswordAuthenticator passwordAuthenticator, PasswordValidator passwordValidator) throws AuthenticationException, PasswordChangeException {
        return validate(subject, credentials, groups);
    }

}