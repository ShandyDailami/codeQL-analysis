public class java_41817_CredentialValidator_A07 {
    public static boolean validate(String password) {
        if (password.length() > 8) {
            if (password.matches(".*[A-Z].*")) {
                if (password.matches(".*[a-z].*")) {
                    if (password.matches(".*[0-9].*")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("Password@123")); // true
        System.out.println(validate("password@123")); // false
        System.out.println(validate("PASSWORD@123")); // false
        System.out.println(validate("Password@12345")); // false
    }
}