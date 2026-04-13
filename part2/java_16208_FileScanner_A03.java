import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16208_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/input.txt"); // input file
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here you can use the line for your security-sensitive operations.
                // For example, here we just print out the line:
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}