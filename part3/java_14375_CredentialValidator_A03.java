import java.util.Base64;
import java.util.Base64.Decoder;

public class java_14375_CredentialValidator_A03 {
    private String encodedCredential;

    public java_14375_CredentialValidator_A03(String credential) {
        this.encodedCredential = encodeCredential(credential);
    }

    private String encodeCredential(String credential) {
        return Base64.getEncoder().encodeToString(credential.getBytes());
    }

    public boolean isCredentialValid(String attempt) {
        Decoder decoder = Base64.getDecoder();
        try {
            decoder.decode(attempt);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("test:test");
        System.out.println(validator.isCredentialValid(validator.encodedCredential));
    }
}