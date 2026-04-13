import java.io.File;
import java.util.Scanner;

public class java_18213_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        System.out.println("Enter the file name to search for:");
        String fileName = scanner.nextLine();

        File file = new File(dir, fileName);
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        System.out.println("Enter the search string:");
        String searchString = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(file)) {
            int lineNumber = 0;
            while (fileScanner.hasNextLine()) {
                lineNumber++;
                String line = fileScanner.nextLine();
                if (line.contains(searchString)) {
                    System.out.println("Found in line " + lineNumber);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}