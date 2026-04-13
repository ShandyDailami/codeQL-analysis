import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class java_03928_FileScanner_A08 {

    private static final String DEFAULT_PASSWORD = "password";
    private static final String MD5 = "MD5";

    public static void main(String[] args) {
        File file = new File("C:\\path\\to\\file");
        if (file.exists()) {
            System.out.println("File exists");
            checkFileIntegrity(file);
        } else {
            System.out.println("File does not exist");
        }
    }

    private static void checkFileIntegrity(File file) {
        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            byte[] fileContent = loadFileContent(file);
            byte[] digest = md.digest(fileContent);
            System.out.println("Integrity check: " + isFileIntegrity(file, digest));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No MD5 algorithm available. Integrity check not possible.");
        }
    }

    private static byte[] loadFileContent(File file) {
        byte[] buffer = new byte[1024];
        try {
            FileInputStream fis = new FileInputStream(file);
            int bytesNumRead = 0;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((bytesNumRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesNumRead);
            }
            fis.close();
            bos.close();
            return bos.toByteArray();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return new byte[0];
        }
    }

    private static boolean isFileIntegrity(File file, byte[] digest) {
        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            byte[] fileContent = loadFileContent(file);
            byte[] digestFromFile = md.digest(fileContent);
            return Arrays.equals(digestFromFile, digest);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No MD5 algorithm available. Integrity check not possible.");
            return false;
        }
    }
}