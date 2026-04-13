import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11518_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner object
        FileScanner scanner = new FileScanner("src/main/resources", false, "*");

        // Use a Scanner to read the input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = input.nextLine();

        // Create a File object
        File dir = new File(dirPath);

        // Use the FileScanner to scan the directory
        scanner.scan(dir);

        // Close the Scanner
        input.close();
    }
}