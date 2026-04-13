import java.nio.file.*;
import java.util.stream.*;

public class java_10189_FileScanner_A08 {
    public static void main(String[] args) {
        Path start = Paths.get(".");

        try (Stream<Path> paths = Files.walk(start)) {
            paths.filter(Files::isRegularFile)
                .map(Path::toAbsolutePath)
                .forEach(Main::printFileInfo);
        } catch (IOException ex) {
            System.err.println("I/O error: " + ex);
        }
    }

    private static void printFileInfo(Path path) {
        long size = Files.size(path);
        String name = path.getFileName().toString();
        System.out.printf("File: %s, Size: %d bytes%n", name, size);
    }
}