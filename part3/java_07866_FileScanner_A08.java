import java.io.File;
import java.util.Scanner;

public class java_07866_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file"); // Replace with your file path
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the word to search:");
        String word = scanner.next();

        int count = 0;
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                if (fileScanner.next().equals(word)) {
                    count++;
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while scanning the file.");
        }

        System.out.println("The word '" + word + "' appears " + count + " times in the file.");
    }
}