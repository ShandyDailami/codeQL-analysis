public class java_10047_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public static boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
       
        }

        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        if (!password.matches(".*[" + SPECIAL_CHARACTERS + "].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validate("Password@123")); // should print true
        System.out.println(validate("password@123")); // should print false
    }
}