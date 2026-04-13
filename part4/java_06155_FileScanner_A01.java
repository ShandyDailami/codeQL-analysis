import java.io.File;
import java.util.Scanner;

public class java_06155_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a scanner for command line input
        Scanner input = new Scanner(System.in);

        // Prompt user for directory
        System.out.print("Enter a directory: ");
        String directory = input.next();

        // Create a File object
        File file = new File(directory);

        // Scan the directory
        File[] list = file.listFiles();

        // Print out the names of the files
        if (list != null) {
            for (File f : list) {
                System.out.println(f.getName());
            }
        } else {
            System.out.println("Invalid directory!");
        }

        // Close the scanner
        input.close();
    }
}