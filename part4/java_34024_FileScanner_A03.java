import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34024_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/test.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Security-sensitive operations related to A03_Injection
            // No code will be generated here. 
            // The operations are purely for learning and demonstration purposes.
        }

        scanner.close();
    }
}