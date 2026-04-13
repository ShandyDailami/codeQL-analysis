import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.credential.Credential;
import java.security.credential.CredentialSubject;
import java.security.credential.SubjectCredentials;

public class java_23672_CredentialValidator_A03 {

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        validator.validateCredentials("user", "password");
    }

    public void validateCredentials(String username, String password) {
        CredentialSubject subject = new CredentialSubject(username);
        Credential credential = new Credential() {
            public CredentialSubject getSubject() {
                return subject;
            }

            public Key getKey() {
                return null;
            }

            public String getType() {
                return "Custom Credential";
            }

            public String getAlgorithm() {
                return "SHA-256";
            }

            public byte[] getEncoded() throws IllegalStateException {
                return hashPassword(password);
            }

            public boolean matches(byte[] encodedKey) throws IllegalStateException {
                return Arrays.equals(encodedKey, hashPassword(password));
            }
        };

        SubjectCredentials subjectCredentials = new SubjectCredentials(subject, credential);

        // Verify credentials
        try {
            subjectCredentials.authenticate(credential);
            System.out.println("Credentials are valid.");
        } catch (Exception e) {
            System.out.println("Invalid credentials.");
        }
    }

    private byte[] hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}