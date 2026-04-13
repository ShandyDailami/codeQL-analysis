public class java_03357_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_03357_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // Stub method that simulates a real authentication process
        // In a real scenario, this method would interact with a database or a third-party service to check the credentials
        return this.username.equals("admin") && this.password.equals("password");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        boolean isValid = validator.validate();
        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}