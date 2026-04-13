import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_29782_FileScanner_A08 {

    public static void main(String[] args) {
        String dir = "/path/to/directory";
        String hashAlgorithm = "SHA-256";
        String hashValue = "4a2119fb2a4a99815a684aaf11c1a25e828b540be55c5d16d8e9ad8b349d5a7e";

        try {
            MessageDigest md = MessageDigest.getInstance(hashAlgorithm);

            File file = new File(dir);
            for (File f : file.listFiles()) {
                if (f.isFile()) {
                    String fileHash = getFileHash(f, md, hashAlgorithm);
                    if (!fileHash.equals(hashValue)) {
                        System.out.println("File " + f.getName() + " has invalid hash.");
                    }
                }
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Unsupported hash algorithm: " + hashAlgorithm);
        }
    }

    private static String getFileHash(File file, MessageDigest md, String hashAlgorithm) {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            byte[] digest = md.digest();
            return bytesToHex(digest);
        } catch (Exception e) {
            return "";
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}