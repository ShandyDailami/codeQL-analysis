import java.io.File;
import java.util.Arrays;
import java.util.List;

public class java_01645_FileScanner_A03 {
    public static void main(String[] args) {
        String path = "/path/to/directory";
        File directory = new File(path);

        // Use listFiles() to get a list of all files in the directory
        File[] files = directory.listFiles();

        // Check if listFiles() returned null
        if (files == null) {
            System.out.println("No files found in directory!");
            return;
        }

        // Create a list to hold the file names
        List<String> fileNames = Arrays.asList(files.toString().split("\\]"));

        // Iterate over the list and print the file names
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }
}