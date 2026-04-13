import java.nio.file.*;
import java.io.*;

public class java_33040_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        Path startingDirectory = Paths.get(".");
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(startingDirectory, "*.java")) {
            for (Path path : dirStream) {
                File file = path.toFile();
                if (file.isFile()) {
                    try (BufferedReader reader = Files.newBufferedReader(path)) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.trim().startsWith("//")) {
                                System.out.println("Comment: " + line);
                            }
                       
                        }
                    }
                }
            }
        }
    }
}