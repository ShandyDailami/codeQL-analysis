import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40304_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/A01_BrokenAccessControl.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // We are not using any security sensitive operations here,
            // so this should be okay without any safety concerns.
            System.out.println(line);
        }

        scanner.close();
    }
}