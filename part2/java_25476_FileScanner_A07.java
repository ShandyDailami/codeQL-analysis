import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25476_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/auth_failure_log.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}