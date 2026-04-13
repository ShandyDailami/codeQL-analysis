public class java_15230_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTER_REGEX = ".*[^a-zA-Z0-9].*";
    private static final String LONG_PASSWORD_REGEX = "^.{8,}$";

    public static boolean validatePassword(String password) {
        return passwordMatchesSpecialCharacter(password) && passwordIsLong(password);
    }

    private static boolean passwordMatchesSpecialCharacter(String password) {
        return password.matches(SPECIAL_CHARACTER_REGEX);
    }

    private static boolean passwordIsLong(String password) {
        return password.matches(LONG_PASSWORD_REGEX);
    }

    public static void main(String[] args) {
        System.out.println(validatePassword("password")); // prints false
        System.out.println(validatePassword("passwor")); // prints false
        System.out.println(validatePassword("password1")); // prints true
    }
}