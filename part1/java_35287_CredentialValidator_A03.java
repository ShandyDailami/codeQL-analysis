public class java_35287_CredentialValidator_A03 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public static boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                hasSpecialCharacter = true;
            }

            if (hasDigit && hasLowerCase && hasUpperCase && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("Password1!")); // Outputs: true
        System.out.println(validate("password1!")); // Outputs: false
        System.out.println(validate("Password123456!")); // Outputs: true
        System.out.println(validate("Password123456@")); // Outputs: false
        System.out.println(validate("Password123456#")); // Outputs: false
    }
}