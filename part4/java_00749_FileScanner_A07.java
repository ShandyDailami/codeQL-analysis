import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class java_00749_FileScanner_A07 {

    public static void main(String[] args) {
        Path path = Paths.get(".");

        try (Stream<Path> paths = Files.walk(path)) {
            paths
                .filter(Files::isRegularFile)
                .filter(file -> file.getFileName().toString().endsWith(".txt"))
                .forEach(file -> scanFileForAuthFailure(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scanFileForAuthFailure(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("A07_AuthFailure")) {
                    System.out.println("AuthFailure found in: " + file.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}