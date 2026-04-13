import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38045_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/access_control_test_file.txt");
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