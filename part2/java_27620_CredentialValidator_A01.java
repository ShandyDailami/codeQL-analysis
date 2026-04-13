public class java_27620_CredentialValidator_A01 {

    public static boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false, hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("ABCDef1!"));
        System.out.println(validate("abc12345"));
        System.out.println(validate("ABCDEF12345!"));
        System.out.println(validate("abcdef12345"));
    }
}