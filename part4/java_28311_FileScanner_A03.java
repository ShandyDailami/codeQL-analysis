import java.nio.file.*;
import java.util.stream.*;

public class java_28311_FileScanner_A03 {

    private static final String DIRECTORY = "path_to_directory"; // replace with your directory path
    private static final String EXTENSION = "ext"; // replace with your file extension

    public static void main(String[] args) {
        try (Stream<Path> paths = Files.find(Paths.get(DIRECTORY), Integer.MAX_VALUE,
                (path, attributes) -> path.toString().endsWith(EXTENSION))) {
            paths.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}