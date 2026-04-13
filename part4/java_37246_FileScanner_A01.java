import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class java_37246_FileScanner_A01 {

    public static void main(String[] args) throws IOException, InterruptedException {
        String dirPath = "/path/to/directory"; // replace with your directory path
        Path path = Paths.get(dirPath);

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (!file.toString().endsWith(".txt")) {
                    // This is a security-sensitive operation. If you want to skip files, you can remove the if statement.
                    return FileVisitResult.CONTINUE;
                }

                File fileToRead = file.toFile();
                FileScanner scanner = new FileScanner(fileToRead);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line); // print the file content, not a security-sensitive operation
                }

                return FileVisitResult.CONTINUE;
            }
        });
    }
}