import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_03651_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists()) {
            Scanner fileScanner;
            try {
                fileScanner = new Scanner(file);
                System.out.println("Enter the line number to search for:");
                int lineNumber = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                // Check for line within file
                int lineCount = 0;
                while (fileScanner.hasNextLine()) {
                    lineCount++;
                    String line = fileScanner.nextLine();
                    if (lineCount == lineNumber) {
                        System.out.println("Line found: " + line);
                        break;
                    }
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        } else {
            System.out.println("File does not exist!");
        }
    }
}