import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_36397_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        Path directory = Paths.get(directoryPath);

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path path : directoryStream) {
                FileAttributes attributes = Files.readAttributes(path, FileAttributes.class);
                if (attributes.isReadable() && !attributes.isWritable()) {
                    System.out.println("Broken access detected in: " + path);
                    // Here you could implement your security-sensitive operations related to A01_BrokenAccessControl
                    // For example, you might check if the file is executable and if it is, you could remove the write permissions
                    // and read permissions.
                }
            }
        } catch (IOException e) {
            System.err.println("Error processing files in directory: " + directoryPath);
            e.printStackTrace();
        }
    }
}