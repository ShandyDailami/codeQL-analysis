import java.util.Base64;

public class java_24126_CredentialValidator_A03 {
    private String realPassword;

    public java_24126_CredentialValidator_A03(String password) {
        this.realPassword = password;
    }

    public boolean validate(String enteredPassword) {
        // Convert enteredPassword to bytes
        byte[] enteredPasswordBytes = enteredPassword.getBytes();

        // Convert realPassword to bytes
        byte[] realPasswordBytes = this.realPassword.getBytes();

        // Encode enteredPasswordBytes to base64
        String encodedEnteredPassword = Base64.getEncoder().encodeToString(enteredPasswordBytes);

        // Encode realPasswordBytes to base64
        String encodedRealPassword = Base64.getEncoder().encodeToString(realPasswordBytes);

        // Compare the encoded passwords
        return encodedEnteredPassword.equals(encodedRealPassword);
    }
}