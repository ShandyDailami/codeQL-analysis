import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileScanner;
import java.nio.file.StandardWatchEventKinds;
import java.util.function.Consumer;

public class java_08874_FileScanner_A03 {
    private static final Path startingDir = Paths.get(".").toAbsolutePath();

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner(startingDir,
                (Consumer<FileVisitReport>) report -> {
                    if (report.getKind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        File createdFile = report.getFile().toFile();
                        if (createdFile.isFile() && createdFile.getName().endsWith(".txt")) {
                            System.out.println("File created: " + createdFile.getAbsolutePath());
                        }
                    }
                },
                (Consumer<Throwable>) ex -> {
                    System.err.println("Error: " + ex.getMessage());
                });
        scanner.watch();
    }
}