import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.FileScanner;
import java.nio.file.PathMatcher;

public class java_09778_FileScanner_A03 {
    public static void main(String[] args) {
        // Define the starting directory
        Path start = FileSystems.getDefault().getPath(".");

        // Create a file system
        FileSystems fs = FileSystems.getDefault();

        // Create a file scanner to list the files in the start directory
        FileScanner scanner = fs.newFileScanner(start, (PathMatcher) null);

        // Print all files and directories in the start directory
        System.out.println("Files and directories in " + start);
        for (Path p : scanner.iterateFiles()) {
            System.out.println(p.toString());
        }

        // Close the scanner
        scanner.close();
    }
}