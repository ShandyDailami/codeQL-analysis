public class java_08228_CredentialValidator_A03 {
    // Fields for user and password
    private String user;
    private String password;

    // Constructor
    public java_08228_CredentialValidator_A03(String user, String password) {
        this.user = user;
        this.password = password;
    }

    // Method for validating the credentials
    public boolean validate() {
        // Here, we'll assume that the validation process is simple:
        // if user is "admin" and password is "password", the validation is successful
        return user.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        // Create a CredentialValidator object with valid credentials
        CredentialValidator validator = new CredentialValidator("admin", "password");
        
        // Call the validate method
        boolean isValid = validator.validate();
        
        // Print the result
        System.out.println("Is valid: " + isValid);
    }
}