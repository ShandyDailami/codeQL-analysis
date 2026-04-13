import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class java_28877_FileScanner_A07 {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory");
            System.exit(0);
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files found in the directory");
            System.exit(0);
        }

        for (File file : files) {
            if (file.isFile()) {
                // Calculate MD5 hash of the file content
                MessageDigest md = MessageDigest.getInstance("MD5");
                try (FileOutputStream fos = new FileOutputStream(file.getPath() + ".md5")) {
                    md.update(Files.readAllBytes(Paths.get(file.getPath())));
                    byte[] digest = md.digest();
                    fos.write(digest);
                } catch (FileNotFoundException | NoSuchAlgorithmException e) {
                    System.out.println("Error calculating MD5 hash for file: " + file.getName());
                    e.printStackTrace();
                }
            }
        }

        System.out.println("MD5 hash calculations complete");
    }
}