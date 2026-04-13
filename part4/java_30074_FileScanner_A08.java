import java.io.File;
import java.util.Scanner;

public class java_30074_FileScanner_A08 {
    public static void main(String[] args) {
        File dir = new File("."); // Point to the current directory

        // Initialize FileScanner
        File[] foundFiles = dir.listFiles();

        if (foundFiles != null) {
            // Print each file name
            for (File file : foundFiles) {
                if (file.isFile()) {
                    System.out.println("File found: " + file.getName());
                }
            }
        }
    }
}