import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_27625_FileScanner_A03 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path startingDirectory = Paths.get("C:\\your_directory\\"); // replace with your directory

        Files.walkFileTree(startingDirectory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {
                    // Do something with the file, e.g. print its name
                    System.out.println("Found text file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}