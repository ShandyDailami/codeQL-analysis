public class java_15121_CredentialValidator_A01 {

    // Assume that the password is hashed
    private String hashedPassword;

    public java_15121_CredentialValidator_A01(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public boolean validate(String plainPassword) {
        // For simplicity, we'll just compare the hashed password to the plain password
        return hashedPassword.equals(hashPassword(plainPassword));
    }

    private String hashPassword(String password) {
        // This is a placeholder for actual password hashing
        // For simplicity, we'll just return the password itself
        return password;
    }
}