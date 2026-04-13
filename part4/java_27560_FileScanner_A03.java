import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27560_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/injection.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);

            // Solution A03_Injection: Injection using StringBuilder
            StringBuilder sb = new StringBuilder();
            sb.append(line);
            sb.append("'"); // Adding single quotes to escape injection
            System.out.println(sb.toString());
        }

        scanner.close();
    }
}