public class java_41024_CredentialValidator_A03 {
    public static void main(String[] args) {
        // Create a password and a username
        String password = "password";
        String username = "user";

        // Print the password and username
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // This is where the security risk comes in: the password is printed
        // unencrypted in the code. This is a serious security risk because anyone
        // who gets access to the source code can see the password.

        // Create a CredentialValidator object
        CredentialValidator credentialValidator = new CredentialValidator();

        // Invoke the validate method on the CredentialValidator object
        // The object is not properly secured, so anyone who gets access to the source code
        // can potentially call the validate method and potentially steal the password
        credentialValidator.validate(username, password);
    }

    // This method is vulnerable to a format string attack
    public void validate(String username, String password) {
        // This is where the security risk comes in again: the password is printed
        // unencrypted in the code. This is again a serious security risk.
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}