import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02631_FileScanner_A08 {
    public static void main(String[] args) {
        String startWith = "A08_"; // This is the string that all files must start with
        String dir = "/path/to/directory"; // Change this to the directory you want to scan

        File file = new File(dir);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith(startWith)) {
                System.out.println("Found a file: " + line);
            }
        }

        scanner.close();
    }
}