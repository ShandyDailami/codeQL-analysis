public class java_30041_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_30041_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // This is a simple check. In a real-world application, you'd want to hash and salt the password before checking it.
        return this.username != null && this.username.equals("admin") && this.password != null && this.password.equals("password");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println(validator.isValid()); // prints false
   
        validator = new CredentialValidator("wrong_username", "password");
        System.out.println(validator.isValid()); // prints false

        validator = new CredentialValidator("admin", "wrong_password");
        System.out.println(validator.isValid()); // prints false

        validator = new CredentialValidator("correct_username", "correct_password");
        System.out.println(validator.isValid()); // prints true
    }
}