import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15709_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a filename:");
            String fileName = scanner.next();
            File file = new File(directory, fileName);

            if (!file.exists()) {
                System.out.println("File not found!");
                return;
            }

            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println("Line: " + line);

                    if (line.contains("authFailure")) {
                        System.out.println("Authentication failure detected!");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}