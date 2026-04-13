import java.nio.file.*;
import java.nio.file.attribute.*;

public class java_30629_FileScanner_A01 {
    public static void main(String[] args) {
        Path start = Paths.get(".");

        try (Stream<Path> paths = Files.walk(start)) {
            paths.forEach(FileScanner::printPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printPath(Path path) {
        try {
            FileAttributes attr = Files.readAttributes(path, FileAttributes.class);
            if (Files.isReadable(path) && Files.isWritable(path)) {
                System.out.println(path);
            } else if (attr.isSymbolicLink()) {
                System.out.println("Symbolic link: " + path);
            } else if (Files.isDirectory(path)) {
                System.out.println("Directory: " + path);
            } else if (Files.isRegularFile(path)) {
                System.out.println("Regular file: " + path);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}