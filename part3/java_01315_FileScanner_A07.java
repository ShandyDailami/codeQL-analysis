import java.io.*;

public class java_01315_FileScanner_A07 {

    public static void main(String[] args) throws IOException {
        // Define the directory to scan
        File directory = new File("/path/to/directory");

        // Define the filter to use for the file name
        String filter = ".*.txt";

        // Use a FileFilter to match files by name
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().matches(filter);
            }
        };

        // Use a FileVisitor to walk the directory tree
        FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                File file = path.toFile();
                if (fileFilter.accept(file)) {
                    // Perform security-sensitive operations
                    // ...
                }
                return FileVisitResult.CONTINUE;
            }
        };

        // Walk the directory tree using the file visitor
        try (FileVisitor<Path> visitor = fileVisitor) {
            Files.walkFileTree(directory.toPath(), visitor);
        }
    }
}