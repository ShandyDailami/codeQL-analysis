import java.io.*;
import java.security.*;

public class java_34701_FileScanner_A03 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String directory = "/path/to/directory"; // Specify the directory path here
        String algorithm = "SHA-256"; // Choose the hashing algorithm, use SHA-256 for security sensitive operations

        File file = new File(directory);
        if (!file.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = file.listFiles();
        if (files == null) return;

        MessageDigest md = MessageDigest.getInstance(algorithm);
        for (File f : files) {
            if (f.isFile()) {
                try (FileInputStream fis = new FileInputStream(f)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        md.update(buffer, 0, length);
                   
                    }
                    System.out.println(f.getName() + ": " + bytesToHexString(md.digest()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String bytesToHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }
}