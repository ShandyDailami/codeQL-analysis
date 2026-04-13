import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36890_FileScanner_A07 {
    public static void main(String[] args) {
        String homeDirectory = System.getProperty("user.home");
        File file = new File(homeDirectory, "A07_AuthFailure.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}