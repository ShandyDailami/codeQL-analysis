public class java_17654_CredentialValidator_A03 {

    public static boolean validateCredentials(String username, String password) {
        // In a real application, you would likely use a database to check the credentials.
        // This is a simplistic example and does not include that functionality.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        if (validateCredentials("admin", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}