import java.nio.file.*;
import java.util.*;
import java.nio.file.attribute.*;

public class java_10266_FileScanner_A07 {
    public static void main(String[] args) {
        Path directory = Paths.get("C:/Users/YourUsername/Documents");
        try (Stream<Path> paths = Files.walk(directory, 1)) {
            paths.filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".txt"))
                .forEach(Main::printFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFile(Path path) {
        System.out.println(path.getFileName());
    }
}