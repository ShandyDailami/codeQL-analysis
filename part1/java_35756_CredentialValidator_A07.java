public class java_35756_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_35756_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // In a real scenario, we would need to connect to a database or a service
        // for authentication and retrieve the user's credentials.
        // For simplicity, we are just comparing hard-coded credentials.
        if (this.username.equals("admin") && this.password.equals("password")) {
            return true;
        } else {
            return false;
        }
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