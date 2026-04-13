import java.io.*;
import java.nio.file.*;
import java.security.*;

public class java_12335_FileScanner_A08 {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String directoryPath = "/path/to/directory";
        String integrityFailureFile = "/path/to/file";

        // Check if the integrity failure file exists
        File integrityFailureFileObj = new File(integrityFailureFile);
        if (!integrityFailureFileObj.exists()) {
            System.out.println("Integrity failure file does not exist!");
            return;
        }

        // Create SHA-256 digest for integrity check
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Get the file contents
        File file = new File(integrityFailureFile);
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[8192];
        int bytesCount = 0;
        while ((bytesCount = fis.read(buffer)) != -1) {
            digest.update(buffer, 0, bytesCount);
        }
        fis.close();

        // Compare the SHA-256 digest of the integrity failure file with the integrity failure file
        byte[] computedDigest = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : computedDigest) {
            sb.append(String.format("%02x", b));
        }
        String expectedDigest = sb.toString();

        // Compare the computed digest with the actual one in the integrity failure file
        MessageDigest actualDigest = MessageDigest.getInstance("SHA-256");
        fis = new FileInputStream(integrityFailureFileObj);
        byte[] actualComputedDigest = new byte[computedDigest.length];
        bytesCount = fis.read(actualComputedDigest);
        actualDigest.update(actualComputedDigest, 0, bytesCount);
        fis.close();
        sb = new StringBuilder();
        for (byte b : actualDigest.digest()) {
            sb.append(String.format("%02x", b));
        }
        String actualExpectedDigest = sb.toString();
        if (!actualExpectedDigest.equals(expectedDigest)) {
            System.out.println("Integrity check failed!");
            return;
        }

        // Use FileScanner to list files in a directory
        File夹 = new File(directoryPath);
        File夹.listFiles(File::isFile).forEach(file -> System.out.println(file.getName()));
    }
}