import java.security.Permission;
import java.security.SecurityPermission;

public class java_40003_CredentialValidator_A07 implements CredentialValidator {

    // Overriding the validate method to check if the given username and password
    // matches the hardcoded values (for the sake of simplicity)
    @Override
    public boolean validate(Credential credential) throws CredentialValidationException {
        String username = credential.getIdentifier();
        String password = credential.getPassword();

        // Hardcoded values
        if (username.equals("test") && password.equals("test")) {
            return true;
        } else {
            throw new CredentialValidationException("Invalid username or password");
        }
    }

    // Overriding the getPermissions method to allow all actions
    @Override
    public Permission[] getPermissions() {
        return new Permission[]{new SecurityPermission("resolveClassloader")};
    }
}