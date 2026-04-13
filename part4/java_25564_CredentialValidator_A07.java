public class java_25564_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_25564_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // Simulate a login attempt. In a real application, this would
        // be replaced with an actual authentication method.
        return username.equals("user") && password.equals("password");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("user", "password");
        if (validator.isValid()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}