import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_38925_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        // Provide a directory path
        File dir = new File(".");

        // Use a FilenameFilter to only visit directories
        FilenameFilter filter = (dir, name) -> name.endsWith("dir");

        FileVisitor visitor = new FileVisitor(dir, filter);
        visitor.traverse();
    }
}

class FileVisitor {
    private File dir;
    private FilenameFilter filter;

    public java_38925_FileScanner_A01(File dir, FilenameFilter filter) {
        this.dir = dir;
        this.filter = filter;
    }

    public void traverse() throws IOException {
        File[] listRoots = dir.listFiles(filter);
        if (listRoots == null) return;

        for (File file : listRoots) {
            if (file.isDirectory()) {
                // Recursively visit directories
                traverse();
            } else if (file.canRead()) {
                // Perform security-sensitive operation
                Files.readAllBytes(file.toPath());
            }
        }
    }
}