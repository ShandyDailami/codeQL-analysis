import java.nio.file.*;
import java.util.stream.*;

public class java_13717_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        Path path = Paths.get(directoryPath);

        try (Stream<Path> walk = Files.walk(path)) {
            walk.forEach(FileScanner::processFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processFile(Path file) {
        String fileName = file.getFileName().toString();

        // This is a very basic security-sensitive operation related to injection
        // Please replace with your actual use case.
        if (fileName.contains("injection")) {
            System.out.println("Detected injection attack in file: " + fileName);
        }
    }
}