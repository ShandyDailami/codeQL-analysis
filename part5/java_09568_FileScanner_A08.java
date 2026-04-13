import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_09568_FileScanner_A08 {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String dirPath = "/path/to/directory"; // Replace with your directory path
        String integrityCheck = "integrityCheck"; // Replace with your integrity check
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (!file.getName().equals(integrityCheck)) {
                        checkFileIntegrity(file);
                    }
                } else if (file.isDirectory()) {
                    checkDirectoryIntegrity(file);
                }
            }
        }
    }

    private static void checkFileIntegrity(File file) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        Path path = Paths.get(file.getAbsolutePath());
        md.update(Files.readAllBytes(path));
        byte[] digest = md.digest();
        String fileIntegrity = bytesToHex(digest);
        if (fileIntegrity.equals("integrityCheck")) {
            System.out.println("Integrity check failed for file: " + file.getName());
        } else {
            System.out.println("Integrity check passed for file: " + file.getName());
        }
    }

    private static void checkDirectoryIntegrity(File dir) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(dir.list().length() + "".getBytes());
        byte[] digest = md.digest();
        String dirIntegrity = bytesToHex(digest);
        if (dirIntegrity.equals("integrityCheck")) {
            System.out.println("Integrity check failed for directory: " + dir.getName());
        } else {
            System.out.println("Integrity check passed for directory: " + dir.getName());
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}