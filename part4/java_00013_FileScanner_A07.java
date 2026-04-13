import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00013_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String fileName = "AuthFailure.txt";
        File file = new File(directory, fileName);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("Found sensitive data: " + line);
        }

        scanner.close();
    }
}