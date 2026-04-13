import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02249_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Get the current working directory
        File currentDir = new File(".");
        
        // Prompt the user to input the file name to be scanned
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to be scanned: ");
        String fileName = scanner.nextLine();

        // Get the file object
        File file = new File(currentDir, fileName);

        // Create a new FileScanner
        FileScanner fileScanner = new FileScanner(file);

        // Use the FileScanner to read the file and print out its content
        fileScanner.readFile();

        scanner.close();
    }
}