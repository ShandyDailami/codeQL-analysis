import java.io.File;
import java.io.FilenameFilter;
import java.io.FileVisitor;
import java.io.IOException;

public class java_05063_FileScanner_A03 {
    private static final String SEARCH_EXTENSION = ".txt";

    public static void main(String[] args) {
        File root = new File(".");
        FileVisitor<Path> visitor = new FileVisitor<Path>() {
            @Override
            public boolean visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(SEARCH_EXTENSION)) {
                    System.out.println("Found file: " + file);
                }
                return true;
            }

            @Override
            public boolean visitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return true;
            }
        };
        int r = new BasicFileAttributes(root).select(visitor, Selectors.files());
        System.out.println("Found " + r + " file(s) in " + root);
    }
}