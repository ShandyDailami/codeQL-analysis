public class java_10049_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";

    public static boolean isValid(String password) {
        if (password == null) {
            return false;
        }
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        if (!password.matches(".*[" + SPECIAL_CHARACTERS + "].*")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("Password1!"));
        System.out.println(isValid("password1!"));
        System.out.println(isValid("Password123!"));
        System.out.println(isValid("Password!123"));
        System.out.println(isValid("Password123!123"));
    }
}