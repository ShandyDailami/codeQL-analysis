public class java_38380_CredentialValidator_A07 {

    public static boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;
        boolean hasDigit = false;
        boolean hasEnoughLength = password.length() >= 8;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isAlphabetic(c)) {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar && hasEnoughLength) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("Password123!")); // true
        System.out.println(validate("password123!")); // false
        System.out.println(validate("PASSWORD123!")); // false
        System.out.println(validate("PASSWORD123!1")); // false
        System.out.println(validate("1PASSWORD123!1")); // false
    }
}