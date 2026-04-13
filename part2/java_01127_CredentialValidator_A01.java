public class java_01127_CredentialValidator_A01 {

    private String username;
    private String password;

    public java_01127_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // This is a placeholder for your actual authentication mechanism.
        // For the sake of this example, we'll just check if the username is "admin" and password is "password".
        // This is a very simple form of access control and is not suitable for a production environment.
        return this.username.equals("admin") && this.password.equals("password");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.isValid()) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}