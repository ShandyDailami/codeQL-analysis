import java.io.File;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class java_20290_FileScanner_A08 {

    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src/main/java"), matcher)) {
            for (Path path : stream) {
                File file = path.toFile();
                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);

                if (file.isFile()) {
                    System.out.println("File: " + file.getPath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getPath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}