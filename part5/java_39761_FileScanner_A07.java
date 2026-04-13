import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39761_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/authFailure.txt");
        if (!file.exists()) {
            throw new IllegalArgumentException("File not found");
        }
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            // Implement security-sensitive operations related to A07_AuthFailure
        }
        scanner.close();
    }
}