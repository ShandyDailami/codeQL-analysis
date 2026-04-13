import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17045_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        // Remove the comment
        // File file = new File("path/to/file");

        // This will allow user to input file name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        scanner.close();

        File file = new File(fileName);

        // This will check if file exists
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        // This will check if user can read the file
        if (!file.canRead()) {
            System.out.println("Access denied for reading the file!");
            return;
        }

        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }
        fileScanner.close();
    }
}