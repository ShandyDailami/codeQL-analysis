import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07090_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/data.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            // Potentially malicious code here
            System.out.println(line);
        }

        scanner.close();
    }
}