import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_38893_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("data.txt");

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        // Check if the file can be read
        if (!file.canRead()) {
            System.out.println("Cannot read the file!");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}