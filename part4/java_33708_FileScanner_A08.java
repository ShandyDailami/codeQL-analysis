import java.io.File;
import java.util.Scanner;
import java.util.FileNotFoundException;

public class java_33708_FileScanner_A08 {

    public static void main(String[] args) {
        try {
            File file = new File("example.txt"); // replace with your file path
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}