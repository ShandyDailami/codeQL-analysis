import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.IOException;
import java.security.Permission;

public class java_09960_FileScanner_A08 {
    public static void main(String[] args) {
        // Define the directory and type of files we're interested in
        String directoryPath = "/path/to/directory";
        String fileExtension = ".txt";
        long maxFileSize = 5 * 1024 * 1024; // 5MB

        // Create a FilePermission object that represents the minimum permission required to read the directory
        Permission permission = new FilePermission.Group(FilePermission.groupToName(java.nio.file.FileAccess.GROUP_READ_FILES), "read");

        try (FileScanner scanner = new FileScanner(directoryPath, permission)) {
            // Scan the directory for files of the specified type and size
            while (scanner.hasNext()) {
                File file = scanner.nextFileInfo();

                // Check if the file is a text file and if it's not too large
                if (file.getName().endsWith(fileExtension) && file.length() < maxFileSize) {
                    // Print the name of the file
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        } catch (SecurityException | FileNotFoundException e) {
            System.out.println("Error reading the directory: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error scanning the directory: " + e.getMessage());
        }
    }
}