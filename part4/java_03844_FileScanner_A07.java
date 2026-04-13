import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_03844_FileScanner_A07 {
    public static void main(String[] args) {
        String fileName = "example.txt";
        String searchWord = "AuthFailure";

        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchWord)) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}