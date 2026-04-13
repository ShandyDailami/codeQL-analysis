import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.AccessControlException;

public class java_14188_FileScanner_A07 {
    private static final String DIRECTORY_TO_SCAN = "path_to_directory"; // replace with your directory

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_TO_SCAN);
        if (!directory.exists()) {
            System.out.println("The directory does not exist!");
            return;
        }

        try (FileScanner fileScanner = new FileScanner(directory)) {
            fileScanner.startScan();
            while (fileScanner.hasNext()) {
                Path path = fileScanner.nextPath();
                if (Files.isReadable(path)) {
                    File file = path.toFile();
                    System.out.println("File: " + file.getName());
                    System.out.println("Size: " + file.length() + " bytes");
                } else {
                    System.out.println("Cannot read file: " + path);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading directory: " + e.getMessage());
        } catch (AccessControlException e) {
            System.out.println("Access denied: " + e.getMessage());
        }
    }
}