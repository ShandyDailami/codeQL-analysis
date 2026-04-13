import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_05618_FileScanner_A03 {

    public static void main(String[] args) {
        scanDirectory("/path/to/directory", ".*\\.java$");
    }

    public static void scanDirectory(String directoryPath, String filePattern) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryPath), filePattern)) {
            for (Path path : directoryStream) {
                if (Files.isDirectory(path)) {
                    System.out.println("Directory: " + path);
                    scanDirectory(path.toString(), filePattern);
                } else {
                    System.out.println("File: " + path);
                    // Here you can add your security-sensitive operation related to A03_Injection
                    // For example, check if the file contains a specific injection point
                }
            }
        } catch (IOException e) {
            System.err.println("Error accessing directory: " + directoryPath);
        }
    }
}