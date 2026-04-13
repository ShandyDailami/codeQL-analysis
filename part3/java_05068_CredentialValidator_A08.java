public class java_05068_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_05068_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // In a real application, this would be a more complex process
        // involving hashing and comparing with stored passwords.
        // This is a simplified example for the sake of this problem.
        return validateUsername() && validatePassword();
    }

    private boolean validateUsername() {
        // Add your username validation logic here
        // For this example, we just check if it's not null
        return username != null;
    }

    private boolean validatePassword() {
        // In a real application, this would be a more complex process
        // involving hashing and comparing with stored passwords.
        // This is a simplified example for the sake of this problem.
        // For this example, we just check if it's not null
        return password != null;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.isValid()) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}