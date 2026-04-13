import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_41932_FileScanner_A01 {

    private final File rootDirectory;

    public java_41932_FileScanner_A01(String rootDirectoryPath) {
        this.rootDirectory = new File(rootDirectoryPath);
    }

    public void scanDirectory() {
        try (Stream<Path> paths = Files.walk(Paths.get(rootDirectory.getPath()))) {
            paths.filter(Files::isRegularFile)
                .map(Path::toFile)
                .forEach(this::printFileInformation);
        } catch (IOException e) {
            System.out.println("Error while scanning directory: " + e.getMessage());
        }
    }

    private void printFileInformation(File file) {
        System.out.println("File: " + file.getName());
    }

    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner("/path/to/directory");
        fileScanner.scanDirectory();
    }
}