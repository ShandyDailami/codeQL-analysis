public class java_41804_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_41804_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // This is a very basic check for username and password. 
        // In a real-world scenario, you would probably want to use a more sophisticated mechanism for checking credentials.
        return (username != null && !username.isEmpty()) && (password != null && !password.isEmpty());
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println("Is valid? " + validator.isValid());
    }
}