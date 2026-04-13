import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_21143_FileScanner_A07 {

    public static void main(String[] args) throws IOException, InterruptedException {

        Path path = Paths.get("your_directory_path");

        if (Files.exists(path) && Files.isDirectory(path)) {
            try (Stream<Path> paths = Files.newDirectoryStream(path)) {
                paths.forEach(file -> {
                    if (Files.isRegularFile(file)) {
                        System.out.println(file.getFileName());
                    }
                });
            }
        } else {
            System.out.println("Provided path is not a valid directory");
        }
    }
}