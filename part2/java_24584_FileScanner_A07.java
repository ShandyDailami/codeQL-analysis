import java.nio.file.*;
import java.io.*;

public class java_24584_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get("path_to_directory"); // replace with your directory

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            for (Path entry : directoryStream) {
                System.out.println(entry.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}