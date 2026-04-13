import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30803_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Prompt user for file path
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        // Create FileScanner instance
        FileScanner fileScanner = new FileScanner(filePath);

        // Check if file exists
        if (fileScanner.fileExists()) {
            // Scan file
            fileScanner.scanFile();
        } else {
            System.out.println("File not found!");
        }

        scanner.close();
    }

    private File file;

    public java_30803_FileScanner_A07(String filePath) {
        this.file = new File(filePath);
    }

    private boolean fileExists() {
        return file.exists();
    }

    private void scanFile() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            // Perform security-sensitive operations (e.g., authentication failure)
            // For simplicity, this code just prints the line
            System.out.println(line);
        }
        fileScanner.close();
    }
}