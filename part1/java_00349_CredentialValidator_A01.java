public class java_00349_CredentialValidator_A01 {
    // This is a mock for a real user's credentials
    private String username;
    private String password;

    public java_00349_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // Simulate a real world authentication system.
        // For simplicity, we're just checking if the user's credentials match
        // with the mock values.
        if (this.username.equals("admin") && this.password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Usage example
        CredentialValidator validator = new CredentialValidator("admin", "password");
        boolean isValid = validator.validate();
        System.out.println("Is the credential valid? " + (isValid ? "Yes" : "No"));
    }
}