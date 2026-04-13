import java.io.File;
import java.io.IOException;

public class java_18675_FileScanner_A07 {
    public static void main(String[] args) throws IOException {
        File root = new File("."); // The current directory

        // Use a FileVisitor to traverse the directory tree
        FileVisitor fileVisitor = new FileVisitor() {
            @Override
            public boolean visitFile(File file, BasicFileAttributes attrs) throws IOException {
                // If the file is a .txt file
                if (file.getName().endsWith(".txt")) {
                    // Read the file and print its content
                    String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                    System.out.println(content);
                }
                return true; // Continue traversing the directory tree
            }

            @Override
            public boolean visitDirectory(File dir, BasicFileAttributes attrs) throws IOException {
                // If the directory is a .auth file
                if (dir.getName().endsWith(".auth")) {
                    // Read the file and print its content
                    String content = new String(java.nio.file.Files.readAllBytes(dir.toPath()));
                    System.out.println(content);
                }
                return true; // Continue traversing the directory tree
            }
        };

        // Start the traversal
        java.io.FileUtils.walkFileTree(root, fileVisitor, 8);
    }
}