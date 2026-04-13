import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30337_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file path: ");
        String filePath = scanner.nextLine();
        File file = new File(filePath);

        if (file.exists()) {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Syntactic sugar: we don't use a full Java library here, but we do use a very minimalistic approach to prevent SQL Injection
                // This is just to demonstrate, you should use a full Java library here
                String sanitizedLine = sanitizeInput(line);
                System.out.println(sanitizedLine);
            }
            fileScanner.close();
        } else {
            System.out.println("File does not exist!");
        }
    }

    // A very minimalistic approach to prevent SQL Injection
    // This is just to demonstrate, in a real world scenario you should use a full Java library here
    private static String sanitizeInput(String input) {
        // This code just removes the characters which are considered safe
        return input.replace(";", "").replace("--", "").replace("DROP", "").replace("--", "").replace("/*", "").replace("*/", "");
    }
}