import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30692_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt"); // replace with your file path
            Scanner scanner = new Scanner(file);

            System.out.println("Enter the word to search for:");
            String searchWord = scanner.nextLine();

            System.out.println("Searching for: " + searchWord);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchWord)) {
                    System.out.println("Found in line: " + line);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}