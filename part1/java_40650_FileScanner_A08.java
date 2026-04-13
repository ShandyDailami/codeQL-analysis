import java.io.*;
import java.nio.file.*;

public class java_40650_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");  // Set the directory path
        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".txt")) {  // Check if the file is a .txt file
                    System.out.println("File: " + file.toString());
                    try (BufferedReader reader = new BufferedReader(new FileReader(file.toString()))) {
                        String line;
                        while ((line = reader.readLine()) != null) {  // Read the content of the file
                            System.out.println(line);
                        }
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}