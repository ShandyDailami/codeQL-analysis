import java.io.*;
import java.nio.file.*;

public class java_23400_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path, "*.java")) {
            for (Path file : dirs) {
                if (Files.isReadable(file)) {
                    try (BufferedReader reader = Files.newBufferedReader(file)) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.trim().startsWith("//")) {
                                System.out.println("Comment found in: " + file.getFileName());
                            }
                        }
                    }
                } else {
                    System.out.println("Cannot read: " + file.getFileName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}