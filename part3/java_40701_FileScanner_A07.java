import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40701_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/auth_failure.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().equalsIgnoreCase("A07_AuthFailure")) {
                System.out.println("AuthFailure detected!");
            }
        }

        scanner.close();
    }
}