public class java_24161_CredentialValidator_A01 {

    public boolean validate(String username, String password) {
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("admin", "password")); // should print true
        System.out.println(validator.validate("user", "password")); // should print false
    }
}