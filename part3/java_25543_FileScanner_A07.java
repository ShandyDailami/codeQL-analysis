import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25543_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/authFailure.txt"); // replace with your own file path
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}