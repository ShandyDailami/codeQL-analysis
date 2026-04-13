import java.io.File;
import java.util.Arrays;

public class java_25538_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File("."); // Get the current directory

        // List all files in the directory
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files found!");
            return;
        }

        // Filter out hidden files
        Arrays.stream(files)
            .filter(file -> !file.isHidden())
            .forEach(file -> System.out.println(file.getName()));
    }
}