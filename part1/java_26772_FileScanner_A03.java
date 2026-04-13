import java.nio.file.*;

public class java_26772_FileScanner_A03 {

    public static void main(String[] args) {
        Path startingPath = Paths.get(".").toAbsolutePath();

        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(startingPath, ".*")) {
            for (Path dir : dirs) {
                if (Files.isDirectory(dir)) {
                    System.out.printf("Directory: %s%n", dir);
                    listFiles(dir);
                } else {
                    System.out.printf("File: %s%n", dir);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void listFiles(Path dir) {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(dir, ".*")) {
            for (Path file : files) {
                if (Files.isRegularFile(file)) {
                    System.out.printf("File: %s%n", file.getFileName());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}