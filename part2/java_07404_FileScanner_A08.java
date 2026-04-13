import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_07404_FileScanner_A08 {

    public static void main(String[] args) {
        String filePath = "path/to/file"; // Replace with your file path
        String expectedChecksum = "expectedChecksum"; // Replace with the expected checksum

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        if (file.length() != getFileChecksum(filePath, expectedChecksum)) {
            System.out.println("File integrity check failed!");
            return;
        }

        System.out.println("File integrity check passed!");
    }

    private static long getFileChecksum(String filePath, String expectedChecksum) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = fis.read(buffer)) > 0) {
                md.update(buffer, 0, lengthRead);
            }
            return md.digest().longValue();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}