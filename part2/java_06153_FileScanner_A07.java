import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06153_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNext()) {
                String filePath = scanner.next();
                try (Scanner fileScanner = new Scanner(new File(filePath))) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        if (line.contains("AuthFailure")) {
                            System.out.println("Found 'AuthFailure' in file: " + filePath);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + e.getMessage());
        }
    }
}