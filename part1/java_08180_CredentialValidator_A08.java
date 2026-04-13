import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialPermission;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_08180_CredentialValidator_A08 implements CredentialValidator {

    private final Set<String> validUsers = new HashSet<>(Arrays.asList(
            "user1",
            "user2",
            "user3",
            "admin"));

    @Override
    public void initialize(Provider provider, AlgorithmParameterSpec paramSpec) {
        // This method is used to initialize the provider and parameter spec
    }

    @Override
    public boolean validate(Credential credential) {
        String username = credential.getIdentifier();
        return validUsers.contains(username);
    }

    @Override
    public Set<Class<?>> getAcceptedCredentialSubtypes() {
        return new HashSet<>(Arrays.asList(Credential.class));
    }

    @Override
    public boolean getAcceptableCredentialSubtypes(Set<Class<?>> acceptableCredentialSubtypes) {
        acceptableCredentialSubtypes.addAll(getAcceptedCredentialSubtypes());
        return true;
    }

    @Override
    public boolean setPassword(Credential credential, String password) {
        // In a real-world application, passwords should never be set with a plain text password
        // This example only demonstrates how to use the password.
        // In a real-world application, passwords should never be set with a plain text password
        credential.setPassword(password.toCharArray());
        return true;
    }

    @Override
    public boolean isPasswordSet(Credential credential) {
        // This method only demonstrates how to use the password.
        // In a real-world application, passwords should never be checked with a plain text password
        char[] password = credential.getPassword();
        return password != null && password.length > 0;
    }

    @Override
    public boolean checkCredential(Credential credential, String password) {
        // This method only demonstrates how to use the password.
        // In a real-world application, passwords should never be checked with a plain text password
        return setPassword(credential, password);
    }

    @Override
    public boolean isLegacy() {
        return true;
    }

    @Override
    public void cleanup() {
        // Cleanup method is not used in a Legacy style.
    }
}