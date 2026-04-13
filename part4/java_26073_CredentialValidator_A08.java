public class java_26073_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_26073_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void validate() throws IntegrityFailure {
        // In real application, you would likely call a service to check the credentials.
        // For now, we just validate that the username and password are not null.
        if (username == null || password == null) {
            throw new IntegrityFailure("Username and password cannot be null");
        }
        
        // If we're here, the username and password are not null, so we can assume they're valid.
        System.out.println("Validated username and password successfully!");
    }

    public static void main(String[] args) {
        try {
            // Try to validate a valid user.
            new CredentialValidator("validUser", "validPassword").validate();
        } catch (IntegrityFailure e) {
            e.printStackTrace();
        }
        
        try {
            // Try to validate an invalid user.
            new CredentialValidator(null, "invalidPassword").validate();
        } catch (IntegrityFailure e) {
            e.printStackTrace();
        }
    }
}