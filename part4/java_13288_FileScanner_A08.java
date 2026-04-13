import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class java_13288_FileScanner_A08 {

    public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("The directory does not exist");
            return;
        }

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        String fileContent = new String(java.nio.file.Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                        byte[] digest = messageDigest.digest(fileContent.getBytes(StandardCharsets.UTF_8));

                        // Print the SHA-256 hash of the file
                        System.out.println(file.getName() + ": " + bytesToHex(digest));

                        // Security-sensitive operation: check file permissions
                        if (file.canRead()) {
                            System.out.println(file.getName() + " is readable");
                        } else {
                            System.out.println(file.getName() + " is not readable");
                        }
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + file.getName());
                    }
                }
            }
        }

        scanner.close();
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}