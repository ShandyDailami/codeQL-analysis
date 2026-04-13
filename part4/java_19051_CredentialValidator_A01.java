public class java_19051_CredentialValidator_A01 {
    // a simple username and password
    private String username = "admin";
    private String password = "password";

    // create a method for validating credentials
    public boolean validate(String user, String pass) {
        if (user != null && user.equals(username) && pass != null && pass.equals(password)) {
            System.out.println("Authentication successful!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("admin", "password");
        validator.validate("wrong_username", "wrong_password");
    }
}