public class java_12785_CredentialValidator_A01 {

    public static boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".indexOf(c) != -1) {
                hasSpecialChar = true;
            }

            if (hasDigit && hasUpperCase && hasLowerCase && hasSpecialChar) {
                break;
            }
        }

        return hasDigit && hasUpperCase && hasLowerCase && hasSpecialChar;
    }

    public static void main(String[] args) {
        String passwords[] = {"password", "Password", "PASSWORD", "12345678", "123abcs", "123@#ABS"};
        for (String password : passwords) {
            System.out.println("Password = " + password + ", is validated = " + validatePassword(password));
        }
    }
}