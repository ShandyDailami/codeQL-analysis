public class java_29673_CredentialValidator_A01 {

    // The CredentialValidator is a service that validates the credentials
    public boolean validate(String username, String password) {

        // Here we're just checking if the password is "secure123"
        // In a real application, you'd want to hash the password and compare the hash to prevent against a pre-computed hash table
        if (password.equals("secure123")) {
            return true;
        } else {
            return false;
        }
    }
}