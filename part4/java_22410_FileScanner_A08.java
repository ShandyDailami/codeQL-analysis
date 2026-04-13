import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22410_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/A08_IntegrityFailure.txt");
            if (!file.exists()) {
                System.out.println("File not found!");
                return;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
}