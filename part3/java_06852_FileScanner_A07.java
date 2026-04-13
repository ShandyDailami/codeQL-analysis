import java.io.File;
import java.util.Scanner;

public class java_06852_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a File object representing the directory to scan
        File file = new File(".");

        // Use a FileFilter to only include files with .txt extensions
        File[] listOfFiles = file.listFiles((dir, name) -> name.endsWith(".txt"));

        // Check if listOfFiles is not null and list all files in directory
        if (listOfFiles != null) {
            for (File txtFile : listOfFiles) {
                System.out.println(txtFile.getName());
            }
        }
    }
}