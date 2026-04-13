import java.io.File;
import java.util.Arrays;

public class java_20075_FileScanner_A08 {
    public static void main(String[] args) {
        // Define the directory path
        String directoryPath = "/path/to/your/directory";

        // Get all files in the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        // Filter out files that do not end with '.txt'
        files = Arrays.stream(files)
                .filter(file -> file.isFile() && file.getName().endsWith(".txt"))
                .toArray(size -> new File[size]);

        // Print each file's name
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}