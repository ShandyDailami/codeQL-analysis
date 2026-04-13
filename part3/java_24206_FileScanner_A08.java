import java.io.File;
import java.util.Scanner;

public class java_24206_FileScanner_A08 {

    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for directory path
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        // Create a FileScanner object for the given directory
        FileScanner fileScanner = new FileScanner(new File(dirPath));

        // Use a FileFilter to only include files with '.txt' extensions
        fileScanner.filter(file -> file.isFile() && file.getName().endsWith(".txt"));

        // Print out the file names
        while (fileScanner.scan()) {
            System.out.println(fileScanner.file().getPath());
        }

        // Close the scanner
        fileScanner.close();
    }
}