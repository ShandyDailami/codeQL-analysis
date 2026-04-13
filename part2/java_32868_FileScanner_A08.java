import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32868_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the current directory
        File currentDir = new File(".");

        // Create a FileScanner object to scan the current directory
        FileScanner scanner = new FileScanner(currentDir);

        // Prompt the user for a file name
        System.out.print("Enter the file name to search: ");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();

        // Search for the file name in the current directory
        boolean isFound = scanner.searchForFile(fileName);

        // Print out whether the file was found or not
        if (isFound) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }
    }

}