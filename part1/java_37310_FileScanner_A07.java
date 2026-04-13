import java.io.File;
import java.util.Scanner;

public class java_37310_FileScanner_A07 {
    private static final String DIRECTORY = "C:\\Users\\User\\Documents\\";
    private static final String FILE_EXTENSION = ".txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File directory = new File(dirPath);
        File file = new File(directory, fileName + FILE_EXTENSION);

        try {
            FileScanner fileScanner = new FileScanner(file);
            fileScanner.startScanning();

            System.out.println("Enter the line number to search for:");
            int lineNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.println("Enter the search term:");
            String searchTerm = scanner.nextLine();

            fileScanner.searchForLine(lineNumber, searchTerm);

            fileScanner.stopScanning();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        scanner.close();
    }
}