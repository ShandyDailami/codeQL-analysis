import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_28835_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileExtension = ".*"; // replace with your file extension

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryPath), fileExtension)) {
            for (Path path : directoryStream) {
                if (Files.isRegularFile(path)) {
                    // This is a file, not a directory, so, do something with it, e.g., print its name
                    System.out.println(path.getFileName());
                } else {
                    // This is a directory, do something else with it, e.g., list its contents
                    listDirectoryContents(path);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void listDirectoryContents(Path path) {
        System.out.println("Directory contents of " + path.getFileName());
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path, ".*")) {
            for (Path file : directoryStream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}