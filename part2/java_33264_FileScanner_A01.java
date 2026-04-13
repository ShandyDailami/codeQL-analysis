import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33264_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/access_control_file.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("WRITE")) {
                System.out.println("Attempting to write to file...");
                // BrokenAccessControl: attempt to write to file
            }
        }
        scanner.close();
    }
}