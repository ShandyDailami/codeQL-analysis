import java.security.Provider;
import java.security.Security;
import java.security.MessageDigest;
import java.security.NoSuchProviderException;

public class java_09183_CredentialValidator_A08 {

    public static void main(String[] args) {
        try {
            Provider provider = Security.getProvider("SUN");
            MessageDigest md = MessageDigest.getInstance("SHA-1", provider);
            byte[] hash = md.digest("supersecurepassword".getBytes());
            System.out.println(hex(hash));
        } catch (NoSuchProviderException | java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String hex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            stringBuilder.append(Character.forDigit((b >> 4) & 0xf, 16));
            stringBuilder.append(Character.forDigit(b & 0xf, 16));
        }
        return stringBuilder.toString();
    }
}