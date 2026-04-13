import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_00360_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/test.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}