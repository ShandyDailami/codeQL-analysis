public class java_01712_CredentialValidator_A03 {

    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("Password@1234")); // Outputs: true
        System.out.println(isValidPassword("password@1234")); // Outputs: false
        System.out.println(isValidPassword("1234@Password")); // Outputs: false
        System.out.println(isValidPassword("PassWord@1234")); // Outputs: false
        System.out.println(isValidPassword("Password1234@")); // Outputs: false
    }
}