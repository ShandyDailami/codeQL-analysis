import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_36064_FileScanner_A08 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String directoryPath = "/path/to/directory";  // Provide your directory path here
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    checkFileIntegrity(file);
                }
            }
        }
    }

    private static void checkFileIntegrity(File file) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[1024];
        int length;

        while ((length = fis.read(data)) != -1) {
            md.update(data, 0, length);
        }
        byte[] digest = md.digest();

        // Convert the bytes to hexadecimal
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }

        System.out.println("File: " + file.getPath());
        System.out.println("MD5: " + sb.toString());
    }
}