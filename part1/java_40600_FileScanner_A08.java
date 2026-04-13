import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_40600_FileScanner_A08 {

    public static void main(String[] args) {
        String directory = "path_to_directory"; // replace with your directory path
        SecuritySensitiveFileScanner scanner = new SecuritySensitiveFileScanner();
        try {
            Files.walkFileTree(Paths.get(directory), scanner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            long size = Files.size(file);
            if (size > 200) {
                System.out.println("File: " + file.toString());
                System.out.println("Size: " + size);
                System.out.println("-------");
                try (BufferedReader reader = new BufferedReader(new FileReader(file.toString()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }
                System.out.println("-------");
            }
            return FileVisitResult.CONTINUE;
        }
    }
}