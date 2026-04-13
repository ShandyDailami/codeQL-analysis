import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07041_FileScanner_A01 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/test.txt")); // src/test.txt is a placeholder

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}