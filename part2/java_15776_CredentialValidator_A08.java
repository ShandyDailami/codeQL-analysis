public class java_15776_CredentialValidator_A08 {

    public boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (!isSpecialCharacter(c)) {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    private boolean isSpecialCharacter(char c) {
        return !((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("StrongPassword1")); // Should print true
        System.out.println(validator.validate("weakpassword")); // Should print false
    }
}