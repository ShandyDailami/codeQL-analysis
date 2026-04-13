import java.nio.file.*;

public class java_01482_FileScanner_A08 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileScanner DIRECTORY");
            System.exit(1);
        }

        Path dir = Paths.get(args[0]);

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir)) {
            for (Path path : dirStream) {
                if (Files.isRegularFile(path)) {
                    System.out.println(path.getFileName());
                }
            }
        } catch (IOException ex) {
            System.out.println("Error reading directory: " + ex.getMessage());
        }
    }
}