import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37171_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            // Prompt user for file path
            System.out.println("Enter the file path: ");
            Scanner scanner = new Scanner(System.in);
            String filePath = scanner.nextLine();

            // Create File object
            File file = new File(filePath);

            // Check if file exists
            if (!file.exists()) {
                System.out.println("File not found!");
                return;
            }

            // Scan the file
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}