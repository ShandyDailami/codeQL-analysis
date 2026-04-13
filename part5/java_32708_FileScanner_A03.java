import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32708_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        String currentDir = new File(".").getAbsolutePath();

        Scanner scanner = new Scanner(new File(currentDir + "/test.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }
}