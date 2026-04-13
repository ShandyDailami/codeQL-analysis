public class java_36079_CredentialValidator_A08 {

    // Strong password criteria:
    // - At least one uppercase letter
    // - At least one lowercase letter
    // - At least one digit
    // - At least one special character
    // - At least one space
    // - Minimum length of 8 characters
    public static boolean isPasswordStrong(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecialCharacter = password.matches(".*[!@#$%^&*()_+\-=\\{\\}[]|:;\"\\?,.<>\\/].*");
        boolean hasSpace = password.contains(" ");

        if (!(hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter && hasSpace)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // You can test the function here
        System.out.println(isPasswordStrong("Abcdefg!123"));  // Should print true
        System.out.println(isPasswordStrong("abcdefg!123"));  // Should print false
        System.out.println(isPasswordStrong("Abc!123456"));  // Should print false
        System.out.println(isPasswordStrong("Abcdefgh!123")); // Should print false
    }
}