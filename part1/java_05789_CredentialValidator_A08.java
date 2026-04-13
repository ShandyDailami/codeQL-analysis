import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_05789_CredentialValidator_A08 {

    // The default salt for bcrypt algorithm
    private static final String DEFAULT_SALT = "2a";
    private static final int BCRYPT_STRENGTH = 12;

    private static SecureRandom sr = new SecureRandom();

    public static void main(String[] args) throws Exception {
        String password = "password";
        System.out.println("Password: " + password);
        String salt = generateSalt();
        System.out.println("Salt: " + salt);
        String hashedPassword = bcrypt(password, salt, BCRYPT_STRENGTH);
        System.out.println("Hashed Password: " + hashedPassword);
    }

    public static String generateSalt() {
        return new String(java.util.Base64.getEncoder().encode(sr.generateSeed(16)));
    }

    public static String bcrypt(String password, String salt, int strength) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(salt.getBytes());
        byte[] bytes = md.digest(password.getBytes());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        int rounds = getRounds(strength);
        for (int i = 0; i < rounds; i++) {
            md.update(sb.toString().getBytes());
            bytes = md.digest(sb.toString().getBytes());
            sb = new StringBuilder();
            for(int j = 0; j < bytes.length ;j++){
                sb.append(Integer.toString((bytes[j] & 0xff) + 0x100, 16).substring(1));
            }
        }
        return sb.toString();
    }

    private static int getRounds(int strength) {
        return (int)Math.ceil(strength / 12.0);
    }
}