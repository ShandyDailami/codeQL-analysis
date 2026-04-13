public class java_26376_CredentialValidator_A01 {

    private String username;
    private String password;

    public java_26376_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // In a real-world application, this would be a complex operation
        // that includes hashing the password and comparing it to a stored hash.
        // For simplicity, we'll just check if the username is "admin" and the password is "password".
        return this.username.equals("admin") && this.password.equals("password");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.isValid()) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}