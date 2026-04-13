import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32334_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }

        if (file.isDirectory()) {
            System.out.println("Given path is a directory, not a file.");
            return;
        }

        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains("AuthFailure")) {
                    System.out.println("AuthFailure found in line: " + line);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}