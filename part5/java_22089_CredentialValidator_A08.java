public class java_22089_CredentialValidator_A08 {

    public static boolean isValid(String password) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        if (password != null && password.length() > 0) {
            hasUpperCase = Character.isUpperCase(password.charAt(0));
            hasLowerCase = Character.isLowerCase(password.charAt(0));
            hasDigit = Character.isDigit(password.charAt(0));
            hasSpecialChar = !(hasUpperCase || hasLowerCase || hasDigit);
        }

        return (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar);
    }

    public static void main(String[] args) {
        System.out.println(isValid("A08_IntegrityFailure"));
    }
}