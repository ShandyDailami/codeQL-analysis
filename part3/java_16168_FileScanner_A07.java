import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16168_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/A07_AuthFailure.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("AuthFailure file not found.");
        }
    }
}