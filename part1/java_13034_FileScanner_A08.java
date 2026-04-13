import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13034_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner instance for the current directory
        FileScanner scanner = new FileScanner(new File("."));

        // Use the scanner to find all .txt files
        File[] txtFiles = scanner.findAll(".txt");

        // Print out the names of the .txt files
        for (File file : txtFiles) {
            System.out.println(file.getName());
        }
    }
}

class FileScanner {
    private File file;

    public java_13034_FileScanner_A08(File file) {
        this.file = file;
    }

    public File[] findAll(String extension) {
        File[] files = file.listFiles((dir, name) -> name.endsWith(extension));
        return files;
    }
}