import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class java_26061_FileScanner_A08 {
    public static void main(String[] args) {
        Path startingDirectory = Paths.get("your_directory_path_here");

        try (Stream<Path> stream = Files.walk(startingDirectory)) {
            stream.filter(Files::isRegularFile)
                  .filter(path -> path.toString().endsWith(".txt"))
                  .forEach(FileScanner::printFileInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFileInfo(Path path) {
        try {
            FileTime lastModifiedTime = Files.getLastModifiedTime(path);
            FileSize fileSize = Files.size(path);

            System.out.printf("File: %s, Last modified: %s, Size: %s%n",
                    path.getFileName(), lastModifiedTime, fileSize);
        } catch (IOException e) {
            System.err.printf("Failed to process file: %s%n", path);
        }
    }
}