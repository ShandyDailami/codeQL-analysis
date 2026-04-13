import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03484_FileScanner_A03 {
    public static void main(String[] args) {
        // Use Scanner to read the input file
        Scanner scanner = new Scanner(System.in);

        // Request for input
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        try {
            // Use FileScanner to list all files in the directory
            FileScanner fileScanner = new FileScanner(new File(path));

            // Print all files in the directory
            while (fileScanner.hasNext()) {
                System.out.println(fileScanner.next());
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + path);
        }

        scanner.close();
    }
}