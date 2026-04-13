public class java_15928_CredentialValidator_A08 {

    public static boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (hasUpperCase && hasLowerCase && hasDigit) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("Password1234")); // should print true
        System.out.println(validate("password1234")); // should print false
        System.out.println(validate("PASSWORD1234")); // should print false
        System.out.println(validate("PASSWORD")); // should print false
    }
}