import java.util.Base64;
import java.util.Base64.Decoder;

public class java_16114_CredentialValidator_A01 {
    private static final String SALT = "salt";
    private static final String STRETCH = "stretch";

    public boolean validate(String plainText, String encryptedText) {
        Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(encryptedText);

        String saltedStretchedText = saltAndStretch(plainText, SALT, STRETCH);
        String saltedAndStretchedText = saltAndStretch(saltedStretchedText, SALT, STRETCH);

        return saltedAndStretchedText.equals(new String(decodedBytes));
    }

    private String saltAndStretch(String text, String salt, int iterations) {
        String saltedText = text + salt;

        for (int i = 0; i < iterations; i++) {
            saltedText = hash(saltedText);
        }

        return saltedText;
    }

    private String hash(String text) {
        return text; // for demonstration purposes, we're just returning the input
    }
}