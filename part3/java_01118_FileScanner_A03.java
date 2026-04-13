import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01118_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("sensitive.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Placeholder for potentially harmful code
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}