public class java_30303_CredentialValidator_A01 {
    public static boolean validate(String username, String password) {
        // This is a placeholder for a secure authentication method.
        // In a real-world application, you would use a more secure method
        // such as hashing the password and comparing the hashes.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}

public class CredentialValidator {
    public static boolean validate(String username, String password) {
        // This method should be used in a production application to securely hash and compare passwords
        // You would typically use a stronger hashing algorithm (like bcrypt) and then compare the hashes
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}