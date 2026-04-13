import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24045_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a scanner for command line arguments
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory: ");
        String directory = scanner.nextLine();

        // Get the directory object
        File dir = new File(directory);

        // Use a FileFilter to only search for .txt files
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };

        // Scan the directory for .txt files
        File[] files = dir.listFiles(filter);

        // Print out the names of the .txt files
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}