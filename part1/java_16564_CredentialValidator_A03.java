public class java_16564_CredentialValidator_A03 {

    // Simple boolean for credential validation
    public static boolean isValid(String username, String password) {
        // In real-world application, this would be a database query or more complex
        // logic to check if the username and password match a record in the database
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        String username = "admin";
        String password = "password";

        if (isValid(username, password)) {
            System.out.println("Credentials are valid!");
        } else {
            System.out.println("Credentials are invalid!");
        }
    }
}