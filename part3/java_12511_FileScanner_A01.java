import java.io.File;
import java.util.ArrayList;

public class java_12511_FileScanner_A01 {
    public static void main(String[] args) {
        // Define the directory
        File directory = new File("/path/to/your/directory");

        // Get a list of all files and directories
        File[] files = directory.listFiles();

        // Create an ArrayList to hold the file names
        ArrayList<String> fileNames = new ArrayList<>();

        // Iterate over the files
        for (File file : files) {
            // If the file is a directory, print its name
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getPath());
            }
            // If the file is a file, print its name
            else {
                fileNames.add(file.getPath());
            }
        }

        // Print the file names
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }
}