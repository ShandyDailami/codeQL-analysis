public class java_23319_CredentialValidator_A01 {

    public static boolean isValidPassword(String password) {
        // Pattern to match a password that is at least 8 characters long,
        // contains at least one digit, one uppercase letter, one lowercase letter, and one special character
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[0-9a-zA-Z@#$%^&*]{8,}$";

        return password.matches(pattern);
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("Password123")); // true
        System.out.println(isValidPassword("password123")); // false
    }
}