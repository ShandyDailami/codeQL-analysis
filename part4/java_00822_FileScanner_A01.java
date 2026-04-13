import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_00822_FileScanner_A01 {

    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileExtension = ".*"; // replace with your file extension

        Path directory = Paths.get(directoryPath);
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory, fileExtension)) {
            for (Path path : directoryStream) {
                File file = path.toFile();
                // handle file here
                System.out.println("File: " + file.getAbsolutePath());
            }
        }
    }
}