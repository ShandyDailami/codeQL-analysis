import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40253_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File fileToSearch = new File(directory, fileName);

        try {
            if (fileToSearch.exists() && !fileToSearch.isDirectory()) {
                Scanner fileScanner = new Scanner(fileToSearch);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    // Perform security-sensitive operations here (e.g., decrypting, validating, etc.)
                    System.out.println(line);
                }
                fileScanner.close();
            } else {
                System.out.println("File not found!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
}