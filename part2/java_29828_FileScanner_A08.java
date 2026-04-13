import java.io.File;
import java.util.Arrays;

public class java_29828_FileScanner_A08 {
    public static void main(String[] args) {
        // Define the directory
        File directory = new File(".");

        // Get all files and directories in the directory
        File[] files = directory.listFiles();

        // Check if files is null
        if(files == null) {
            System.out.println("No files or directories found!");
            return;
        }

        // Print the names of all files and directories
        Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
    }
}