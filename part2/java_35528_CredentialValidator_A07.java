import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.util.encoders.HexEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Base64;

public class java_35528_CredentialValidator_A07 {
    private static final String SALT = "salt";

    public static String hashPassword(String password, String salt) {
        return hashPassword(password, salt, 1000);
    }

    public static String hashPassword(String password, String salt, int iterations) {
        byte[] k = MessageDigest.getInstance("SHA256").digest((salt + password).getBytes(StandardCharsets.UTF_8));
        byte[] i = new byte[4];
        for (int j = 1; j < iterations; j++) {
            k = MessageDigest.getInstance("SHA256").digest(merge(k, i, (salt + password).getBytes(StandardCharsets.UTF_8)));
            i = new byte[j * 4];
        }
        return new HexEncoder(new SHA256Digest()).encode(k);
    }

    private static byte[] merge(byte[] a, byte[] b, byte[] c) {
        int aLen = a.length;
        int bLen = b.length;
        int cLen = c.length;

        byte[] dest = new byte[aLen + bLen + cLen];
        System.arraycopy(a, 0, dest, 0, aLen);
        System.arraycopy(b, 0, dest, aLen, bLen);
        System.arraycopy(c, 0, dest, aLen + bLen, cLen);

        return dest;
    }

    public static boolean validatePassword(String password, String salt, String hashedPassword) {
        return hashPassword(password, salt, 1000).equals(hashedPassword);
    }
}