import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class java_35256_FileScanner_A08 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            checkDirectoryIntegrity(directory);
        } else {
            System.out.println("Invalid directory");
        }

        scanner.close();
    }

    private static void checkDirectoryIntegrity(File directory) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    checkFileIntegrity(file, messageDigest);
                } else if (file.isDirectory()) {
                    checkDirectoryIntegrity(file);
                }
            }
        }
    }

    private static void checkFileIntegrity(File file, MessageDigest messageDigest) throws NoSuchAlgorithmException {
        // Hash the file's contents using SHA-256
        byte[] fileContent = new byte[1024];
        int bytesCount;

        FileInputStream fileInputStream = new FileInputStream(file);
        while ((bytesCount = fileInputStream.read(fileContent)) != -1) {
            messageDigest.update(fileContent, 0, bytesCount);
        }
        fileInputStream.close();

        byte[] computedDigest = messageDigest.digest();
        // Compare the computed digest with the one stored in the file
        // If they match, the integrity check passed, otherwise the integrity failure occurred
    }
}