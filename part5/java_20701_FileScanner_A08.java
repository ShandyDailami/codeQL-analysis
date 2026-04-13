import java.io.*;
import java.security.*;

public class java_20701_FileScanner_A08 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";
        scanDirectory(directory);
    }

    public static void scanDirectory(String directory) {
        File[] files = new File(directory).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    checkFileIntegrity(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file.getPath());
                }
            }
        }
    }

    public static void checkFileIntegrity(File file) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            fis.close();
            byte[] digest = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            String hash = sb.toString();

            String filePath = file.getPath();
            String expectedHash = // calculate expected hash of the file

            if (!hash.equals(expectedHash)) {
                System.out.println("File " + filePath + " has integrity failure.");
            } else {
                System.out.println("File " + filePath + " is valid.");
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}