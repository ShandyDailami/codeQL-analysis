import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_15325_FileScanner_A08 {
    public static void main(String[] args) {
        String homeDir = System.getProperty("user.home");
        File file = new File(homeDir, "test.txt");

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[1024];
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            int read;
            while ((read = fis.read(bytes)) != -1) {
                md.update(bytes, 0, read);
            }

            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            String calculatedDigest = sb.toString();

            if (calculatedDigest.equals(fileIntegrity(file))) {
                System.out.println("File integrity verified");
            } else {
                System.out.println("File integrity failed");
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String fileIntegrity(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] bytes = new byte[1024];
            int read;
            while ((read = fis.read(bytes)) != -1) {
                md.update(bytes, 0, read);
            }

            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}