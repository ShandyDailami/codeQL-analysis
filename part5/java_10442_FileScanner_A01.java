import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class java_10442_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        File directory = new File("."); // Get the current directory
        getFilesRecursively(directory)
                .filter(Main::isValidFile)
                .map(Main::getFileSize)
                .forEach(System.out::println);
    }

    private static boolean isValidFile(File file) {
        return !file.isHidden() && file.canRead() && file.isFile();
    }

    private static long getFileSize(File file) {
        try (Stream<Path> stream = Files.list(Paths.get(file.getAbsolutePath()))) {
            return stream.count();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static Stream<File> getFilesRecursively(File directory) {
        try {
            return Stream.of(directory).flatMap(Main::getFilesRecursively);
        } catch (Exception e) {
            return Stream.empty();
        }
    }
}