import java.io.*;
import java.security.*;

public class java_29477_FileScanner_A03 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String filePath = "your_file_path";
        String hashAlgorithm = "SHA-256";

        File file = new File(filePath);
        MessageDigest digest = MessageDigest.getInstance(hashAlgorithm);

        byte[] fileData = new byte[1024];
        int bytesRead;

        FileInputStream fis = new FileInputStream(file);
        while ((bytesRead = fis.read(fileData)) != -1) {
            digest.update(fileData, 0, bytesRead);
        }
        fis.close();

        byte[] hash = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        System.out.println("Hash of " + file.getName() + ": " + sb.toString());
    }
}