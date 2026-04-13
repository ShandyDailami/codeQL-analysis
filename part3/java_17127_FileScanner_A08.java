import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_17127_FileScanner_A08 {

    public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String expectedChecksum = "expectedChecksum"; // replace with your expected checksum

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (checkFileIntegrity(file, expectedChecksum)) {
                        System.out.println("File " + file.getPath() + " has integrity failure");
                    }
                }
            }
        }
    }

    private static boolean checkFileIntegrity(File file, String expectedChecksum) throws NoSuchAlgorithmException, FileNotFoundException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int bytesCount = 0;

        while ((bytesCount = fis.read(buffer)) != -1) {
            md.update(buffer, 0, bytesCount);
        }

        byte[] digest = md.digest();

        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString().equals(expectedChecksum);
    }
}