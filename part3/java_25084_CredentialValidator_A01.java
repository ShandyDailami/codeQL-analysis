public class java_25084_CredentialValidator_A01 {

    // A simple method to check if a username and password are valid
    public boolean isValid(String username, String password) {
        // You would normally use a database or some other form of persistent storage to check
        // This is just a simple and insecure comparison
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        BasicCredentialValidator validator = new BasicCredentialValidator();
        // You would normally call this method in a security context
        boolean isValid = validator.isValid("admin", "password");
        if (isValid) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}