public class java_19676_CredentialValidator_A01 {
    public static boolean isPasswordStrongEnough(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else {
                hasSpecialCharacter = true;
            }

            if (hasUpperCase && hasLowerCase && hasNumber && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPasswordStrongEnough("aA1B2C3D4E5F6")); // Password is strong enough
        System.out.println(isPasswordStrongEnough("aA")); // Password is not strong enough
    }
}