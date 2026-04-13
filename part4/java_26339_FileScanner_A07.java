import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26339_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/authfailures.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}