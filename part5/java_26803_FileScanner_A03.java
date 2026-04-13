import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26803_FileScanner_A03 {
    public static void main(String[] args) {
        // a secure method to find files in a directory
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        // a list to hold file names
        String[] fileNames = directory.list();

        // a scanner to read from standard input
        Scanner scanner = new Scanner(System.in);

        // prompt the user for a file name
        System.out.print("Enter a file name: ");
        String userInput = scanner.nextLine();

        // attempt to open the user's file
        File userFile = new File(directoryPath + "/" + userInput);

        // check if the user's file exists
        if (!userFile.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        // attempt to open the user's file for reading
        try (Scanner fileScanner = new Scanner(userFile)) {
            // read and print the contents of the file
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}