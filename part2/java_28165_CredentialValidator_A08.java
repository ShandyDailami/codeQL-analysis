public class java_28165_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String password = credential.getPassword();
        if (password.length() < 8) {
            throw new CredentialException("Password is too short. It must contain at least 8 characters.");
        }
        if (!hasUpperCase(password)) {
            throw new CredentialException("Password must contain at least one uppercase letter.");
        }
        if (!hasLowerCase(password)) {
            throw new CredentialException("Password must contain at least one lowercase letter.");
        }
        if (!hasDigit(password)) {
            throw new CredentialException("Password must contain at least one digit.");
        }
        if (!hasSpecialChar(password)) {
            throw new CredentialException("Password must contain at least one special character.");
        }
        return true;
    }

    private boolean hasUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpecialChar(String password) {
        String specialChars = "!@#$%^&*()";
        for (int i = 0; i < password.length(); i++) {
            if (specialChars.indexOf(password.charAt(i)) != -1) {
                return true;
            }
        }
        return false;
    }
}