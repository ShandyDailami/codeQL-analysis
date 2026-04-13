public class java_02392_CredentialValidator_A07 {

    public static boolean validate(String username, String password) {
        // This is a simple example. In a real-world application, you should check against a real database.
        // In a real-world application, you should not store passwords in plain text.
        // This example does not use encryption or secure storage.
        if (username == null || username.isEmpty()) {
            return false;
        }
        if (password == null || password.isEmpty()) {
            return false;
        }
        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        if (validate("admin", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}