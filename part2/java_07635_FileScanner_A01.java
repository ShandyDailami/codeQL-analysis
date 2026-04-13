import java.io.File;
import java.util.Scanner;

public class java_07635_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("test.txt");
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (Exception e) {
                System.out.println("An error occurred while reading the file.");
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }
}