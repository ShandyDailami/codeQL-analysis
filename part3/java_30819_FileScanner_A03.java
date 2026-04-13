import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30819_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/data.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);

            // You can add more security-sensitive operations here, for example,
            // a password check using a hash function.
            // In this case, we're leaving it as is, as it's not related to A03_Injection.
        }

        scanner.close();
    }
}