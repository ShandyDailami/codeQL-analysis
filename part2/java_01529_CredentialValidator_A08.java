public class java_01529_CredentialValidator_A08 {

    public static boolean validate(String password) {
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean specialChar = false;

        if (password.matches(".*[Uu].*")) {
            upperCase = true;
        }
        if (password.matches(".*[Ll].*")) {
            lowerCase = true;
        }
        if (password.matches(".*[0-9].*")) {
            digit = true;
        }
        if (password.matches(".*[!@#\\$%\\^&\\*].*")) {
            specialChar = true;
        }

        return upperCase && lowerCase && digit && specialChar;
    }

    public static void main(String[] args) {
        System.out.println(validate("Password@123")); // true
        System.out.println(validate("password@123")); // false
    }
}