public class java_19133_CredentialValidator_A01 {

    // This is just a simple demonstration of a credential validator
    // in a real-world application, it would typically use a secure hash
    // algorithm such as SHA-256 to securely hash and compare user passwords

    private String username;
    private String password;

    public java_19133_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        // In a real-world application, this would typically compare the
        // hashed password in the database to a hashed version of the entered
        // password

        // For demonstration purposes, we'll just return true or false
        // for simplicity
        return (username.equals("test") && password.equals("password"));
    }
}