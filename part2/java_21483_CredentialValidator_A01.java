public class java_21483_CredentialValidator_A01 {

    public static boolean validate(String password) {
        if (password == null) {
            return false;
        }

        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasSpecialChar = password.matches(".*[^a-zA-Z0-9].*");

        return hasNumber && hasUpperCase && hasLowerCase && hasSpecialChar;
    }

    public static void main(String[] args) {
        System.out.println(validate("Password@123")); // true
        System.out.println(validate("password@123")); // false
        System.out.println(validate("PASSWORD@123")); // false
        System.out.println(validate("PASSWORD@1234")); // true
        System.out.println(validate("password")); // false
        System.out.println(validate("")); // false
    }
}