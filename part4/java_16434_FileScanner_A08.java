import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_16434_FileScanner_A08 {
    public static void main(String[] args) throws IOException, SecurityException {
        Path path = Paths.get("C:/Temp/");
        FileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);

        // Check if the file or directory is encrypted
        if (attributes.isEncrypted()) {
            System.out.println("The file or directory is encrypted, cannot access. Exiting...");
            return;
        }

        // Check if the file or directory is a directory
        if (!attributes.isDirectory()) {
            System.out.println("The provided path is not a directory, cannot access. Exiting...");
            return;
        }

        // Check if the file or directory has read permission
        if (!attributes.permissions().contains(FileAttributeView.Permissions.grantRead())) {
            System.out.println("The provided file or directory does not have read permission, cannot access. Exiting...");
            return;
        }

        // Check if the file or directory has write permission
        if (!attributes.permissions().contains(FileAttributeView.Permissions.grantWrite())) {
            System.out.println("The provided file or directory does not have write permission, cannot access. Exiting...");
            return;
        }

        // If the file or directory has both read and write permission, then it's safe to access
        System.out.println("Accessing the file or directory is allowed.");
    }
}