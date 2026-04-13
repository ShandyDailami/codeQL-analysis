import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class java_17249_FileScanner_A07 {
    public static void main(String[] args) {
        Path path = Paths.get("path_to_your_file"); // Replace with your file path

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                // You can add more logic here to check for authentication failure in the line
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}