public class java_05425_CredentialValidator_A08 {

    // Private field to store the hashed password
    private byte[] hashedPassword;

    // Constructor that accepts the hashed password
    public java_05425_CredentialValidator_A08(byte[] hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    // Method to check if the provided password matches the hashed password
    public boolean isValidPassword(String password) {
        // First, we need to hash the provided password
        byte[] providedPasswordBytes = password.getBytes();
        byte[] providedPasswordAndSaltBytes = new byte[providedPasswordBytes.length + hashedPassword.length];

        System.arraycopy(providedPasswordBytes, 0, providedPasswordAndSaltBytes, 0, providedPasswordBytes.length);
        System.arraycopy(hashedPassword, 0, providedPasswordAndSaltBytes, providedPasswordBytes.length, hashedPassword.length);

        // Then we can check if the hashed version of the provided password is equal to the stored hashed password
        return MessageDigest.getInstance("SHA-256").digest(providedPasswordAndSaltBytes).equals(this.hashedPassword);
    }

}