public class java_33619_CredentialValidator_A07 {

    public static boolean validateCredentials(String username, String password) {
        // for demonstration purposes, we're just checking if the password is "password"
        if (password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // testing the validateCredentials method
        if (validateCredentials("username", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}