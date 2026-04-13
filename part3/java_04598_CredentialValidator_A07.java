public class java_04598_CredentialValidator_A07 {

    public boolean validateCredentials(String username, String password) {
        // Simulate a check against a database
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkAuthorization(String username, String password) {
        if (validateCredentials(username, password)) {
            System.out.println("User authorized successfully!");
            return true;
        } else {
            System.out.println("Invalid username or password!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.checkAuthorization("admin", "password");
        validator.checkAuthorization("wrong_username", "wrong_password");
    }
}