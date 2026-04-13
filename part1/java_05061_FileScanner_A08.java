import java.nio.file.*;

public class java_05061_FileScanner_A08 {
    public static void main(String[] args) {
        Path start = Paths.get(".");

        try (DirectoryStream<Path> files = Files.newDirectoryStream(start)) {
            for (Path path : files) {
                if (Files.isDirectory(path) && !path.toString().startsWith(".")) {
                    System.out.println("Directory: " + path);
                } else if (Files.isRegularFile(path) && !path.toString().startsWith(".")) {
                    System.out.println("File: " + path);
                }
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}