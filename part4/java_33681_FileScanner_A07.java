import java.io.File;
import java.util.List;

public class java_33681_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a new File object for the current directory
        File currentDir = new File(".");
        
        // Get a list of all files in the current directory
        File[] files = currentDir.listFiles();

        // Check if there are files in the current directory
        if (files != null) {
            // Loop through each file in the current directory
            for (File file : files) {
                // If the file is not a directory, print its name
                if (!file.isDirectory()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}