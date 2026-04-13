public class java_12382_CredentialValidator_A07 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false, hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                hasSpecialChar = true;
            }
            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        System.out.println(validator.validate("strongPassword@123")); // Returns true
        System.out.println(validator.validate("password")); // Returns false
    }
}