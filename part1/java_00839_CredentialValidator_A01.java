public class java_00839_CredentialValidator_A01 {

    public static boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        boolean hasDigit = false, hasUpperCase = false, hasLowerCase = false, hasSpecialChar = false;

        if (password.length() >= 8) {
            hasDigit = true;

            if (password.matches(".*[A-Z].*")) {
                hasUpperCase = true;
            }

            if (password.matches(".*[a-z].*")) {
                hasLowerCase = true;
           
            }

            if (password.matches(".*[@,#,$,%].*")) {
                hasSpecialChar = true;
            }
        }

        return hasDigit && hasUpperCase && hasLowerCase && hasSpecialChar;
    }

    public static void main(String[] args) {
        System.out.println(isPasswordStrong("Password@123"));  // should return true
        System.out.println(isPasswordStrong("password"));  // should return false
        System.out.println(isPasswordStrong("PASSWORD"));  // should return false
        System.out.println(isPasswordStrong("12345678"));  // should return false
        System.out.println(isPasswordStrong("!@#$%^&*"));  // should return false
        System.out.println(isPasswordStrong("password@123"));  // should return false
    }
}