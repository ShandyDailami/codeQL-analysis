public class java_24697_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_24697_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // Simplified way to check for username and password
        // In a real-world application, you'd actually connect to a database to check the credentials
        return this.username != null && this.username.equals("admin") && this.password != null && this.password.equals("password");
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");

        if (validator.isValid()) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}