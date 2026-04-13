import java.io.File;
import java.util.Arrays;

public class java_00330_FileScanner_A03 {
    public static void main(String[] args) {
        // Use current directory
        File currentDir = new File(".");

        // List all files in the current directory
        File[] files = currentDir.listFiles();

        // Check if files exist
        if (files == null) {
            System.out.println("No files in current directory");
            return;
        }

        // Print out file names
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}