import java.io.File;
import java.util.Scanner;

public class java_18893_FileScanner_A01 {

    public static void main(String[] args) {
        try {
            File file = new File("test.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
           
                // This is where we would perform some security-sensitive operation.
                // The specific operation will depend on the requirements of the problem.
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("An error occurred while scanning the file.");
            e.printStackTrace();
        }
    }
}