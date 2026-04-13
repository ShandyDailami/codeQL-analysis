import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_30045_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");

        if (file.exists()) {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } else {
            System.out.println("File not found.");
        }
    }
}