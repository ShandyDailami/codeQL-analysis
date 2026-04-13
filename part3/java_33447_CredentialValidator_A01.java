public class java_33447_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public static boolean validatePassword(String password) {
        if (password == null || password.length() < 8 || !password.matches(".*[0-9].*") || !password.matches(".*[" + SPECIAL_CHARACTERS + "].*")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validatePassword("password123!")); // should print true
        System.out.println(validatePassword("PASSWORD123!")); // should print false, not long enough
        System.out.println(validatePassword("PASSWORD123")); // should print false, not long enough
        System.out.println(validatePassword("PASSWORD12345678")); // should print false, no digit
        System.out.println(validatePassword("PASSWORD12345678!")); // should print true
    }
}