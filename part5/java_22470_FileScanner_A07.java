import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22470_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("A07_AuthFailure.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().startsWith("auth_failure")) {
                    System.out.println("Auth Failure detected in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("AuthFailure file not found. Exiting program.");
            e.printStackTrace();
        }
    }
}