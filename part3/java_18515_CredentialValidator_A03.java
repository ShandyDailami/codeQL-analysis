public class java_18515_CredentialValidator_A03 {
    public boolean validateCredentials(String username, String password) {
        // This is a dummy authentication method. 
        // In a real-world application, the actual authentication process would involve hashing the password and comparing the hash to the stored hash.
        // However, for the purpose of this example, we'll simulate this process.
        return (username.equals("admin") && password.equals("password"));
    }
}

public class InjectionExample {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Example usage:
        String username = "admin";
        String password = "password";

        boolean valid = validator.validateCredentials(username, password);

        if (valid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}