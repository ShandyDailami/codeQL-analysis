public class java_01321_CredentialValidator_A01 {

    public static boolean validate(String username, String password) {
        // This is a simple mock validation for the sake of example.
        // In real world, this would usually involve sending a request to a security service
        // and checking the response for access permissions.

        // For the sake of simplicity, we will just check if the password is "password".
        // In a real-world application, you would use a more complex validation method.
        return password.equals("password");
    }

    public static void main(String[] args) {
        String username = "admin";
        String password = "password";

        if (validate(username, password)) {
            System.out.println("Access granted for user: " + username);
        } else {
            System.out.println("Access denied for user: " + username);
        }
    }
}