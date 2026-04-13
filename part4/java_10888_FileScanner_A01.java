import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_10888_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        File directory = new File(directoryPath);

        // Create a filter to only include directories
        FileFilter directoryFilter = (File file) -> file.isDirectory();

        File[] directoryContents = directory.listFiles(directoryFilter);

        if (directoryContents != null) {
            Arrays.stream(directoryContents).forEach(file -> System.out.println(file.getName()));
        } else {
            System.out.println("No directory contents found.");
        }
    }
}