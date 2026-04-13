public class java_15648_CredentialValidator_A07 {
    // CredentialValidator Interface requires a call to authenticate method
    @Override
    public boolean authenticate(String userId, String password) {
        // Simulating authentication process
        // Here, we're just checking if the userId is 'admin' and the password is 'password'
        if ("admin".equals(userId) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // CredentialValidator Interface requires a call to getMessage method
    @Override
    public String getMessage() {
        // Here, we're returning a custom message for invalid credentials
        return "Invalid username or password";
    }

    // CredentialValidator Interface requires a call to clearMessage method
    @Override
    public void clearMessage() {
        // No need to clear a message in this example
    }
}

// Example usage:
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CustomValidator();

        // Simulating user interaction
        if (validator.authenticate("admin", "password")) {
            System.out.println("Authentication successful");
        } else {
            System.out.println(validator.getMessage());
        }

        validator.clearMessage();
    }
}