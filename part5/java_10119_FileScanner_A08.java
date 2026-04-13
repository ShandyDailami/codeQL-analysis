import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_10119_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner fileScanner = new Scanner(System.in);

        System.out.println("Please enter the file path:");
        String filePath = fileScanner.nextLine();

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File does not exist!");
                return;
            }

            if (!file.canRead()) {
                System.out.println("Permission denied for reading the file!");
                return;
            }

            fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // This line intentionally left blank
            }

            System.out.println("File reading completed successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } finally {
            fileScanner.close();
        }
    }
}