import java.util.Base64;

public class java_41733_CredentialValidator_A03 {

    public static boolean validateCredential(String credential) {
        // Check if credential is base64 encoded
        if (isBase64Encoded(credential)) {
            // Decode base64 credential
            String decodedCredential = new String(Base64.getDecoder().decode(credential), StandardCharsets.UTF_8);

            // Check if credential is not null or empty
            if (decodedCredential != null && !decodedCredential.isEmpty()) {
                // Check if credential contains 'A03_Injection'
                if (decodedCredential.contains("A03_Injection")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isBase64Encoded(String string) {
        try {
            return Base64.getDecoder().decode(string).length != string.length();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validateCredential function
        String credential = "ZW5jb2RlZFN0cmluZw=="; // "TestA03_Injection" in base64
        System.out.println(validateCredential(credential));
    }
}