import java.io.*;
import java.nio.file.*;

public class java_03687_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("."); // Replace with your path

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path, "*.txt")) {
            for (Path file : dirs) {
                try (BufferedReader reader = Files.newBufferedReader(file)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Perform your security-sensitive operation here
                        // For example, print the line to console
                        System.out.println(line);
                    }
                }
            }
        }
    }
}