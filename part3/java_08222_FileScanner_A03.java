import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class java_08222_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        String extension = ".txt";
        Files.walkFileTree(Paths.get("."), new SimpleFileVisitor<>(), 8)
            .forEach(path -> {
                if (Files.isRegularFile(path) && path.toString().endsWith(extension)) {
                    System.out.println("Found file: " + path.toString());
                    // Here you could insert code related to A03_Injection
                    // For example, here we remove the file if it contains a dangerous string
                    try {
                        byte[] byteBuffer = Files.readAllBytes(path);
                        String str = new String(byteBuffer);
                        if (str.contains("dangerous_string")) {
                            Files.delete(path);
                            System.out.println("File removed: " + path.toString());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
    }
}