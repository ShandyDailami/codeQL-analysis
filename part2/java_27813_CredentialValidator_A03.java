public class java_27813_CredentialValidator_A03 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";

    @Override
    public boolean validate(String username, String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can not be null");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        if (!containsLowerCase(password)) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter");
        }

        if (!containsUpperCase(password)) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter");
        }

        if (!containsNumber(password)) {
            throw new IllegalArgumentException("Password must contain at least one number");
        }

        if (!containsSpecialCharacter(password)) {
            throw new IllegalArgumentException("Password must contain at least one of the symbols $@#");
        }

        return true;
    }

    private boolean containsLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i)))
                return true;
        }
        return false;
    }

    private boolean containsUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i)))
                return true;
        }
        return false;
    }

    private boolean containsNumber(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (NUMBERS.contains(String.valueOf(password.charAt(i))))
                return true;
        }
        return false;
    }

    private boolean containsSpecialCharacter(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (SPECIAL_CHARACTERS.contains(String.valueOf(password.charAt(i))))
                return true;
        }
        return false;
    }
}