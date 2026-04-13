import java.io.File;
import java.util.Scanner;

public class java_33344_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the directory path
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a FileScanner object to read files from the directory
        FileScanner fileScanner = new FileScanner(new File(directoryPath));

        // Print each file's content
        while (fileScanner.hasNext()) {
            File file = fileScanner.next();
            System.out.println("Content of file " + file.getName() + ":");
            fileScanner.printLines(System.out);
        }

        // Close the scanner
        fileScanner.close();
   
    }
}