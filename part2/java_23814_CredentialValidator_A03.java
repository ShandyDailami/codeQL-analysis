public class java_23814_CredentialValidator_A03 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public static boolean validate(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        if (!password.matches(".*[!@#$%^&*()].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validate("Password@123")); // prints true
        System.out.println(validate("password")); // prints false
    }
}