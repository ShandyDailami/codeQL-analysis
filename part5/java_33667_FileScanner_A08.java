import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33667_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_your_file");

        if (file.exists()) {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } else {
            System.out.println("File does not exist!");
        }
    }
}