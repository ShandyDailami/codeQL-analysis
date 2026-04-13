public class java_29339_CredentialValidator_A03 {

    private String correctUsername;
    private String correctPassword;

    public java_29339_CredentialValidator_A03(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    public boolean validate(String username, String password) {
        // You can add a delay here to simulate an insecure password
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Compare the correct password with a hashed version of the input password
        return correctPassword.equals(hashPassword(password));
    }

    // A simple hashing function that could be used in a real application
    private String hashPassword(String password) {
        // This is a very basic hashing function for demonstration purposes
        return password + "hashed";
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");

        // Simulate user logging in with incorrect credentials
        if (!validator.validate("user", "wrongpassword")) {
            System.out.println("Invalid credentials");
        } else {
            System.out.println("Access granted");
        }
    }
}