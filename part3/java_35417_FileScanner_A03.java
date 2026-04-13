import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_35417_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_your_file.txt"); // replace with your file path
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}