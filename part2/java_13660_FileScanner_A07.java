import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13660_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/file.txt"); // replace with your file path
        Scanner scanner = new Scanner(file);

        String target = "target string"; // replace with your target string
        int lineNumber = 1;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(target)) {
                System.out.println("Line " + lineNumber + " contains target string");
            }
            lineNumber++;
        }

        scanner.close();
    }
}