import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_09735_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // specify your directory path
        String fileExtension = "txt"; // specify your file extension

        Path path = Paths.get(directoryPath);
        FileSystems fs = FileSystems.newFileSystem(path, null);
        Stream<Path> paths = fs.getRootDirectories().flatMap(dir ->
                Stream.of(dir.resolve("."))
                      .flatMap(File::new java.io.File::listFiles)
                      .filter(file -> file.isFile() && file.getName().endsWith(fileExtension))
        );

        paths.forEach(file -> System.out.println("File found: " + file.toString()));
    }
}