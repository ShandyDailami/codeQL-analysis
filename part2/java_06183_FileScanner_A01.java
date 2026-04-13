import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_06183_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        Path directory = Paths.get(directoryPath);

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    FileAttributes attributes = Files.readAttributes(path, FileAttributes.class);
                    long size = attributes.size();
                    boolean isHidden = attributes.isHidden();

                    if (isHidden) {
                        System.out.println("Hidden file: " + path);
                    } else if (size > 512) {
                        System.out.println("Large file: " + path);
                    } else {
                        System.out.println("Regular file: " + path);
                    }
                } else if (Files.isDirectory(path)) {
                    System.out.println("Directory: " + path);
                } else {
                    System.out.println("Other type: " + path);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}