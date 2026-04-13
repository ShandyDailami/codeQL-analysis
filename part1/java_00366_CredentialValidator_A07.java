import com.sun.security.auth.module.PasswordModule;

public class java_00366_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public PasswordCredential validate(PasswordCredential pc) throws AuthenticationException {
        String password = pc.getPasswordAsString();

        if (password == null || password.length() < 8) {
            throw new AuthenticationFailedException("Password must be at least 8 characters long");
        }

        if (!password.matches(".*[0-9].*")) {
            throw new AuthenticationFailedException("Password must contain at least one number");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new AuthenticationFailedException("Password must contain at least one uppercase letter");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new AuthenticationFailedException("Password must contain at least one lowercase letter");
        }

        if (!password.matches(".*[!@#$%^&*()_+-=].*")) {
            throw new AuthenticationFailedException("Password must contain at least one of the symbols $@#");
        }

        // If password passed all checks, return the password
        return pc;
    }
}