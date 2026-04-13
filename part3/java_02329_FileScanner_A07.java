import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_02329_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name: ");
        String fileName = scanner.nextLine();

        try {
            File file = new File(fileName);
            if (file.exists()) {
                Scanner fileScanner = new Scanner(file);
                System.out.println("Enter the string to search: ");
                String searchString = scanner.nextLine();

                int lineNumber = 0;
                while (fileScanner.hasNextLine()) {
                    lineNumber++;
                    String line = fileScanner.nextLine();
                    if (line.contains(searchString)) {
                        System.out.println("String found in line " + lineNumber + ": " + line);
                    }
                }
                fileScanner.close();
            } else {
                System.out.println("File not found");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}