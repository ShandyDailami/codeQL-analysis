import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21214_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file path:");
        String filePath = scanner.nextLine();
        scanner.close();

        File file = new File(filePath);

        if (file.exists()) {
            if (file.canRead()) {
                Scanner fileScanner = new Scanner(file);

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();

                    // Security-sensitive operation, e.g., checking for a specific string in a line
                    if (line.contains("A07_AuthFailure")) {
                        System.out.println("Security violation detected in line: " + line);
                    }
                }

                fileScanner.close();
            } else {
                System.out.println("Cannot read file: " + filePath);
            }
        } else {
            System.out.println("File not found: " + filePath);
        }
    }
}