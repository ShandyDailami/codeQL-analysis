public class java_00299_CredentialValidator_A08 {
    public static boolean validate(String username, String password) {
        // You can replace this with actual login method if you want
        // Here we're just checking if the username and password are correct
        return (username.equals("user") && password.equals("password"));
    }

    public static void main(String[] args) {
        // Test the validate method
        boolean result = validate("user", "password");
        if (result) {
            System.out.println("Credentials are valid!");
        } else {
            System.out.println("Credentials are invalid!");
        }
    }
}