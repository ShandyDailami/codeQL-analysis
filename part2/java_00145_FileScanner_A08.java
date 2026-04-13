import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_00145_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        // Create a File object
        File file = new File(directoryPath + "/" + fileName);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        // Scan the file
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }
        fileScanner.close();

        // Check if the file can be read
        if (!file.canRead()) {
            System.out.println("Cannot read the file!");
        }

        // Check if the file can be written
        if (!file.canWrite()) {
            System.out.println("Cannot write to the file!");
        }
    }
}