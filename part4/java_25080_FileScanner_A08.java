import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class java_25080_FileScanner_A08 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        String storedHash = getHash(filePath);

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        if (checkIntegrity(file, storedHash)) {
            System.out.println("File integrity is secure!");
        } else {
            System.out.println("File integrity is not secure!");
        }
    }

    private static String getHash(String filePath) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] fileContent = readFile(filePath);
        messageDigest.update(fileContent);
        return Arrays.toString(messageDigest.digest());
    }

    private static byte[] readFile(String filePath) throws NoSuchAlgorithmException {
        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int bytesCount = 0;
            while ((bytesCount = fis.read(buffer)) != -1) {
                messageDigest.update(buffer, 0, bytesCount);
            }
        } catch (Exception e) {
            throw new NoSuchAlgorithmException(e.getMessage());
        }
        return messageDigest.digest();
    }

    private static boolean checkIntegrity(File file, String storedHash) {
        String calculatedHash;
        try {
            calculatedHash = getHash(file.getPath());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return calculatedHash.equals(storedHash);
    }
}