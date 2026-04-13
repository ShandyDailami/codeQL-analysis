public class java_11967_CredentialValidator_A08 {
    // Define a hash function for passwords
    private static MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public boolean validatePassword(String password) {
        // Generate a hash from the password
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String encryptedPassword = sb.toString();
        // Compare the hash with the stored hash
        return encryptedPassword.equals(storedPassword);
    }
}