import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06326_FileScanner_A01 {
    public static void main(String[] args) {
        // create a file scanner
        Scanner scanner = new Scanner(System.in);

        // get the file path from user input
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        // try to open the file
        File file = new File(filePath);

        // check if the file exists
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        // create a file scanner for the file
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}