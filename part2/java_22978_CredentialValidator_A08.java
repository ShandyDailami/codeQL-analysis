public class java_22978_CredentialValidator_A08 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("testPassword");
    }

    private void validate(String password) {
        if (isPasswordStrong(password)) {
            System.out.println("Password is strong");
        } else {
            System.out.println("Password is weak");
        }
    }

    private boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasLowercase = false;
        boolean hasUppercase = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }

            if (hasDigit && hasLowercase && hasUppercase) {
                return true;
            }
        }

        return false;
    }
}