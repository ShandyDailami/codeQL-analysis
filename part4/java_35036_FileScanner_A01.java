import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35036_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/access_control_test.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // This is where the security-related code will be
            // We'll just print out the line for now, as the problem statement doesn't specify what security-related operations should be performed
            System.out.println(line);
        }
        scanner.close();
    }
}