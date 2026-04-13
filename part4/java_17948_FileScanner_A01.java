import java.io.File;
import java.util.Scanner;

public class java_17948_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}