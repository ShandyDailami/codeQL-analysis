import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_34220_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = input.nextLine();
        System.out.println("Enter the file name:");
        String fileName = input.nextLine();

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}