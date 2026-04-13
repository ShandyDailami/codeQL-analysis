public class java_11290_CredentialValidator_A01 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("user", "secret");
    }

}

class CredentialValidator {

    public boolean validate(String username, String password) {
        // If the username and password match, return true
        if (username.equals("user") && password.equals("secret")) {
            System.out.println("Access granted!");
            return true;
        // Otherwise, return false
        } else {
            System.out.println("Access denied!");
            return false;
        }
    }

}