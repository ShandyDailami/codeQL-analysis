public class java_33331_CredentialValidator_A01 {

    private String username;
    private String password;

    public java_33331_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValidUsername() {
        // This is a simple validation. In a real-world application,
        // you would need to use a more complex algorithm to ensure
        // that the username is not too long, contains invalid characters,
        // etc.
        return username != null && !username.trim().isEmpty();
    }

    public boolean isValidPassword() {
        // This is a simple validation. In a real-world application,
        // you would need to use a more complex algorithm to ensure
        // that the password is not too short, contains invalid characters,
        // etc.
        return password != null && !password.trim().isEmpty();
    }

    public boolean validate() {
        return isValidUsername() && isValidPassword();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("username", "password");
        System.out.println(validator.validate()); // Prints: true
    }
}