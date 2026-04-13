import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_15878_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get(".").toAbsolutePath().normalize();
        try (DirectoryStream<Path> dirs = Files.newDirectoryStream(dir)) {
            for (Path path : dirs) {
                if (Files.isDirectory(path)) {
                    listDirectory(path, 1);
                } else {
                    System.out.println(path.toString());
                }
            }
        }
    }

    private static void listDirectory(Path path, int level) throws IOException {
        String indent = "";
        for (int i = 0; i < level; i++) {
            indent += "  ";
        }
        System.out.println(indent + path.getFileName());
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
            for (Path file : files) {
                if (Files.isDirectory(file)) {
                    listDirectory(file, level + 1);
                } else {
                    System.out.println(indent + "  " + file.getFileName());
                }
            }
        }
    }
}