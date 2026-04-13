import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class java_35764_FileScanner_A03 {

    private String keyword;

    public java_35764_FileScanner_A03(String keyword) {
        this.keyword = keyword;
    }

    public void search(String directory) throws IOException {
        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().contains(keyword)) {
                    System.out.println("File: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        };

        File root = new File(directory);
        if (root.exists() && root.isDirectory()) {
            root.visit(visitor);
        }
    }

    public static void main(String[] args) throws IOException {
        String directory = "/path/to/directory";
        String keyword = "keyword";
        FileScanner scanner = new FileScanner(keyword);
        scanner.search(directory);
    }
}