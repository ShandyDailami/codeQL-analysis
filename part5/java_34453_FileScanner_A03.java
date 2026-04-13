import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_34453_FileScanner_A03 {
    public static void main(String[] args) {
        File currentDir = new File(".");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter directory:");
            String dirPath = scanner.nextLine();

            if (!currentDir.getCanonicalPath().startsWith(dirPath)) {
                System.out.println("Incorrect path");
                return;
            }

            System.out.println("Enter filename:");
            String fileName = scanner.nextLine();

            Path filePath = Path.of(dirPath, fileName);

            if (Files.exists(filePath)) {
                System.out.println("File already exists");
                return;
            }

            File newFile = new File(filePath.toString());

            if (newFile.createNewFile()) {
                System.out.println("File created successfully");

                System.out.println("Enter some text:");
                String text = scanner.nextLine();

                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] messageDigest = md.digest(text.getBytes());

                Files.write(filePath, text.getBytes(), StandardOpenOption.CREATE);

                System.out.println("Text has been hashed and saved successfully");
            } else {
                System.out.println("Failed to create file");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No such algorithm");
        } catch (Exception e) {
            System.out.println("An error has occurred");
        }
    }
}