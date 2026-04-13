public class java_31394_CredentialValidator_A08 {

    public static boolean validateCredentials(String username, String password) {
        // This is a placeholder for a real-world operation.
        // In a real-world scenario, passwords should be hashed and compared
        // to prevent security vulnerabilities.
        // In this example, we are just checking if the username is "admin" and password is "password".
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        String username = "admin";
        String password = "password";

        if (validateCredentials(username, password)) {
            System.out.println("Access granted for user: " + username);
        } else {
            System.out.println("Access denied for user: " + username);
        }
    }
}