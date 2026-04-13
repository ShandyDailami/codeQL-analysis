import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class java_36839_FileScanner_A03 {
    public static void main(String[] args) {
        Path start = Paths.get(".");
        fileScan(start, true);
    }

    private static void fileScan(Path start, boolean printContent) {
        try (Stream<Path> paths = Files.walk(start)) {
            paths.forEach(path -> {
                if (Files.isRegularFile(path)) {
                    try (InputStream in = Files.newInputStream(path)) {
                        if (printContent) {
                            System.out.println("File: " + path);
                            System.out.println("Content: " + new String(Files.readAllBytes(path), StandardCharsets.UTF_8));
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + path);
                    }
                } else if (Files.isDirectory(path)) {
                    System.out.println("Directory: " + path);
                    fileScan(path, printContent);
                }
            });
        } catch (IOException e) {
            System.out.println("Error walking the path");
        }
    }
}