import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35987_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("."); // get current directory
        String filename = "AuthFailure.txt";
        File file = new File(directory, filename);

        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("File path: " + line);
            }
            scanner.close();
        } else {
            System.out.println("File not found!");
        }
    }
}