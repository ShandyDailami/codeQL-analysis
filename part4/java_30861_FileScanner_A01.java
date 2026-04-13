import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30861_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner
        FileScanner fileScanner = new FileScanner();

        // Use the FileScanner to scan a directory
        File directory = new File(".");
        fileScanner.scanDirectory(directory, new FileVisitor() {
            @Override
            public void visit(File file) {
                // This is where you could put your security-sensitive operations
                // In this example, we'll just print the file name
                System.out.println("Scanning file: " + file.getName());
            }

            @Override
            public void endDirectory(File directory, int i) {
                // This is where you could put your security-sensitive operations
                // In this example, we'll just print a message
                System.out.println("Ending directory scan: " + directory.getName());
            }
        });
    }
}

interface FileVisitor {
    void visit(File file);
    void endDirectory(File directory, int i);
}

class FileScanner {
    public void scanDirectory(File directory, FileVisitor visitor) {
        // This is a very basic implementation of a FileScanner
        // In a real implementation, you would use a more sophisticated algorithm
        // This implementation also doesn't handle file permissions, which are a security concern
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                visitor.endDirectory(file, 0);
                scanDirectory(file, visitor);
            } else {
                visitor.visit(file);
            }
        }
    }
}