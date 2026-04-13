public class java_20406_CredentialValidator_A08 {

    public static boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false, hasLowerCase = false, hasSpecialChar = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
           
            } else if (!Character.isLetter(ch)) {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("Password@123")); // true
        System.out.println(validate("password@123")); // false
        System.out.println(validate("Passw0rd@123")); // false
        System.out.println(validate("Password123")); // false
    }
}