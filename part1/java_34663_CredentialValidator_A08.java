import java.security.InvalidParameterException;

public class java_34663_CredentialValidator_A08 {
    private String encryptedPassword;
    private String encryptedSalt;

    public java_34663_CredentialValidator_A08(String encryptedPassword, String encryptedSalt) {
        this.encryptedPassword = encryptedPassword;
        this.encryptedSalt = encryptedSalt;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public void setEncryptedSalt(String encryptedSalt) {
        this.encryptedSalt = encryptedSalt;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public String getEncryptedSalt() {
        return encryptedSalt;
    }

    public boolean isPasswordCorrect(String password) {
        return password.equals(encryptedPassword);
    }

    public boolean isSaltCorrect(String salt) {
        return salt.equals(encryptedSalt);
    }

    public boolean isCredentialsCorrect(String password, String salt) {
        if (password == null || salt == null) {
            throw new InvalidParameterException("Credentials cannot be null");
        }

        return isPasswordCorrect(password) && isSaltCorrect(salt);
    }
}