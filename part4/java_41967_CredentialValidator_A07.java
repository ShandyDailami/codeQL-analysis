public class java_41967_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password must not be null");
        }

        if (!hasUpperCase(password) || !hasLowerCase(password) || !hasDigit(password)) {
            throw new AuthenticationFailedException("Password must contain at least one uppercase letter, one lowercase letter, and one digit");
        }

        // Continue with authentication here...

        return true;
    }

    private boolean hasUpperCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLowerCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}