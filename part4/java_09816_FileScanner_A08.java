import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_09816_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/data.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                // Process the line (e.g., print it or manipulate it)
                System.out.println(line);
            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}