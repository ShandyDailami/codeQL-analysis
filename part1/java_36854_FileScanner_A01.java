import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36854_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("."); // Use current directory
        String[] fileList = directory.list(); // List all files in directory

        // Print file list
        for (String file : fileList) {
            System.out.println(file);
        }

        // Use Scanner to read each file
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to read:");
        String fileName = scanner.nextLine();

        if (fileName.equals(fileList[0])) { // If input matches the first file
            System.out.println("Reading the file...");
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } else {
            System.out.println("Access denied!");
        }

        scanner.close();
    }
}