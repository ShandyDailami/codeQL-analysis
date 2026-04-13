import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_21757_FileScanner_A03 {
    private static final PathMatcher<Path> FILE_EXP = PathMatchers.matching(Paths.get("**.java"), file -> true);

    public static void main(String[] args) throws IOException {
        FileSystem fileSystem = FileSystems.getDefault();
        Stream<Path> paths = fileSystem.getRootDirectories().flatMap(dir -> Stream.of(dir).map(Path::toAbsolutePath).map(fileSystem::getPath).filter(Files::exists);
        paths.flatMap(path -> Stream.of(path)).flatMap(path -> walkDirectory(path)).forEach(file -> processFile(file));
    }

    private static Stream<Path> walkDirectory(Path path) {
        try {
            return Files.walk(path, 1)
                .filter(Files::isRegularFile)
                .filter(path -> FILE_EXP.matches(path))
                .peek(file -> System.out.println("Matched file: " + file.toString()));
        } catch (IOException e) {
            e.printStackTrace();
            return Stream.empty();
        }
    }

    private static void processFile(Path path) {
        // TODO: Implement file processing
        System.out.println("Processing file: " + path.toString());
    }
}