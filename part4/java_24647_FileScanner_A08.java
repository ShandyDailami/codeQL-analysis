import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24647_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/file.txt"); // Adjust this as needed
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}