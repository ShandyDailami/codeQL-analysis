public class java_31911_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String password = credential.getPassword();

        // Check if password is too short
        if (password.length() < 8) {
            throw new GeneralSecurityException("Password is too short. Must be at least 8 characters.");
        }

        // Check if password has a certain set of characters
        if (!(password.matches(".*[a-z].*"))) {
            throw new GeneralSecurityException("Password must contain at least one lowercase letter.");
        }

        if (!(password.matches(".*[A-Z].*"))) {
            throw new GeneralSecurityException("Password must contain at least one uppercase letter.");
        }

        if (!(password.matches(".*[0-9].*"))) {
            throw new GeneralSecurityException("Password must contain at least one numeric character.");
        }

        if (!(password.matches(".*[!@#\\&\\*$].*"))) {
            throw new GeneralSecurityException("Password must contain at least one of the symbols !@#&*$");
        }

        return true;
    }
}