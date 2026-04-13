import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12055_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/authfailure.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
        }
    }
}