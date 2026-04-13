public class java_23907_CredentialValidator_A08 {

    private static final String SALT = "salt";

    private java_23907_CredentialValidator_A08() {
        // Prevent instantiation
    }

    public static boolean validate(String plainText, String hashedText) {
        return hashedText.equals(hashPassword(plainText));
    }

    public static String hashPassword(String password) {
        return hashPassword(password, SALT);
    }

    public static String hashPassword(String password, String salt) {
        return hashPassword(password, salt, "SHA-1");
    }

    public static String hashPassword(String password, String salt, String algorithm) {
        return DigestUtils.md5Hex(salt + password + salt);
    }
}