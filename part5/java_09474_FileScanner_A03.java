import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09474_FileScanner_A03 {

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/test.txt"); // replace with your file path
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // replace with your security-sensitive operations
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}