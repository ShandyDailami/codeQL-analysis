import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03045_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("path/to/file.txt");
        Scanner scanner = new Scanner(file);
        String target = "desired string";

        boolean containsTarget = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(target)) {
                containsTarget = true;
                break;
            }
        }
        scanner.close();

        if (containsTarget) {
            System.out.println("Target string found in the file.");
        } else {
            System.out.println("Target string not found in the file.");
        }
    }
}