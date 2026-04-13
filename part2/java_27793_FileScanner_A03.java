import java.io.File;
import java.util.Scanner;

public class java_27793_FileScanner_A03 {

    public static void main(String[] args) {

        // Create a new FileScanner instance with the directory
        // to scan as the argument
        FileScanner fileScanner = new FileScanner(args[0]);

        // Use the scanner to find all files in the directory
        File[] files = fileScanner.getFiles();

        // Iterate over the list of files
        for (File file : files) {
            // Print the name of each file
            System.out.println(file.getName());
        }
    }
}

class FileScanner {

    private File file;

    public java_27793_FileScanner_A03(String pathname) {
        this.file = new File(pathname);
    }

    public File[] getFiles() {
        return file.listFiles();
    }
}