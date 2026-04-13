import java.io.File;
import java.util.Scanner;

public class java_19611_FileScanner_A07 {
    public static void main(String[] args) {
        // Get the current directory
        File currentDir = new File(".");

        // Use a FileFilter to only scan files
        File[] listOfFiles = currentDir.listFiles((dir, name) -> name.endsWith(".txt"));

        // Print out the names of the files
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No .txt files in current directory.");
        }
    }
}