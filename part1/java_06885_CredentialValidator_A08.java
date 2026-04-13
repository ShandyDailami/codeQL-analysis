public class java_06885_CredentialValidator_A08 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("admin", "password")); // true
        System.out.println(validator.validate("user", "password")); // false
    }

    public boolean validate(String username, String password) {
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}