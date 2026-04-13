import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01764_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_your_file");
        Scanner scanner = new Scanner(file);

        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }

        System.out.println("Number of lines in the file: " + lineCount);

        scanner.close();
    }
}