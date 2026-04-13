public class java_31092_CredentialValidator_A07 {
    // Step 1: Import the required packages.
    import java.util.Base64;
    import java.security.MessageDigest;
    import java.security.NoSuchAlgorithmException;

    // Step 2: Create the CredentialValidator class.
    public class CredentialValidator {

        // Step 3: Implement the validate method.
        public boolean validate(String username, String password) {
            // Step 4: Calculate the SHA-256 hash of the password.
            String securePassword = calculateSHA256Hash(password);

            // Step 5: Compare the secure password to the stored password.
            // Note: For simplicity, we'll use a hard-coded version of the password.
            if (securePassword.equals("5e884898da280471eabf429b6996bdc62f112a48a81d32febeeac0f63b831b5") {
                return true;
            }
            return false;
        }

        // Step 6: Implement the calculateSHA256Hash method.
        private String calculateSHA256Hash(String password) {
            // Step 7: Create a MessageDigest instance and update it with the password.
            MessageDigest digest;
            try {
                digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(password.getBytes("UTF-8"));
                
                // Step 8: Convert the hash bytes to a Base64 string.
                StringBuilder hexString = new StringBuilder();
                for (byte b : hash) {
                    String hex = Integer.toHexString(0xff & b);
                    if(hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                return hexString.toString();
            } catch(NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }
}