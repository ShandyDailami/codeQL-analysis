import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class java_29915_FileScanner_A08 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();
        File file = new File(directory, fileName);
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }
        System.out.println("Enter the desired algorithm (MD5, SHA-1, SHA-256):");
        String algorithm = scanner.nextLine();
        MessageDigest messageDigest;
        switch (algorithm) {
            case "MD5":
                messageDigest = MessageDigest.getInstance("MD5");
                break;
            case "SHA-1":
                messageDigest = MessageDigest.getInstance("SHA-1");
                break;
            case "SHA-256":
                messageDigest = MessageDigest.getInstance("SHA-256");
                break;
            default:
                return;
        }
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                byte[] bytes = line.getBytes();
                messageDigest.update(bytes);
            }
            byte[] digest = messageDigest.digest();
            for (byte b : digest) {
                System.out.printf("%02x", b);
            }
        } catch (Exception e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}