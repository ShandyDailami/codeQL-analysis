import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_41866_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "./src/main/java"; // Replace with your directory path
        String fileExtension = "java";

        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            paths.filter(Files::isRegularFile)
                 .filter(path -> path.toString().endsWith("." + fileExtension))
                 .map(Path::toFile)
                 .forEach(file -> {
                     try {
                         String content = Files.readString(file.toPath());
                         System.out.println(content);
                     } catch (IOException e) {
                         System.out.println("Error reading file: " + file.toString());
                     }
                 });
        } catch (IOException e) {
            System.out.println("Error walking the directory: " + directoryPath);
        }
    }
}