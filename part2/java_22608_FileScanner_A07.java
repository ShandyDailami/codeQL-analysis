import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22608_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/A07_AuthFailure.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("AuthFailure")) {
                System.out.println("Line contains: " + line);
            }
        }

        scanner.close();
    }
}