import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25046_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("."); // The current directory

        // Create a FileScanner that will list all the files in the directory
        FileScanner fileScanner = new FileScanner(directory, true);

        // Use a Scanner to read the file names
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of a file: ");
        String fileName = scanner.next();

        // Use a loop to check if the file exists
        while (fileScanner.hasNext()) {
            File file = fileScanner.nextFile();
            if (file.getName().equals(fileName)) {
                System.out.println("File found: " + file.getPath());
                return;
            }
        }

        System.out.println("File not found!");
    }
}