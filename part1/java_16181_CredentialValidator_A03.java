public class java_16181_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_16181_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // This is a simplistic approach to a security sensitive operation.
        // In real-world applications, this would involve hashing and comparing passwords
        // to a secure storage.

        // For this example, we'll just check if the username is "admin" and password is "password".
        // This is a simple and not very secure method of validating credentials.
        return this.username.equals("admin") && this.password.equals("password");
    }
}

public class Main {
    public static void main(String[] args) {
        // Injecting a dummy credential validator for demonstration purposes
        CredentialValidator validator = new CredentialValidator("test", "password");

        if(validator.validate()) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}