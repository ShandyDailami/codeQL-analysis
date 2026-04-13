import java.io.File;
import java.util.Scanner;

public class java_10959_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = input.nextLine();
        System.out.println("Enter the word to search for:");
        String searchWord = input.nextLine();

        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains(searchWord)) {
                    System.out.println("Line containing the search word: " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while trying to read the file: " + e.getMessage());
        }
    }
}