import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40148_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Ask for directory name
        System.out.println("Please enter a directory name:");
        String dirName = scanner.nextLine();

        // Create a File object for the directory
        File dir = new File(dirName);

        // Create a FileFilter for text files
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                // Accept only .txt files
                return pathname.getName().endsWith(".txt");
            }
        };

        // List all text files in the directory
        File[] textFiles = dir.listFiles(filter);
        for (File file : textFiles) {
            System.out.println(file.getName());
        }

        // Close the Scanner
        scanner.close();
    }
}