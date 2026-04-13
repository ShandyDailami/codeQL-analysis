import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_06292_FileScanner_A07 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingDirectory = Paths.get("."); // Change this to your directory
        FilesystemExceptionHandler.logAndHandle(
                () -> listFiles(startingDirectory),
                "Error listing files in " + startingDirectory
        );
    }

    private static void listFiles(Path dir) throws IOException {
        try (Stream<Path> entries = Files.list(dir).parallel()) {
            entries.forEach(System.out::println);
        }
    }

    private static class FilesystemExceptionHandler {
        public static void logAndHandle(Supplier<Stream<Path>> supplier, String errorMessage) {
            try {
                supplier.get().forEach(Main::printInfo);
            } catch (Exception e) {
                System.err.println(errorMessage);
                e.printStackTrace(System.err);
           
                // We can't handle the exception here, but we can do it in another thread
                new Thread(() -> e.printStackTrace(System.err)).start();
            }
        }

        private static void printInfo(Path path) {
            System.out.println(path.toString());
        }
    }
}