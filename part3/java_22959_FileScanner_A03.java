import java.io.File;
import java.security.Permission;
import java.util.Scanner;

public class java_22959_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\YourUsername\\Desktop\\yourFile.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}