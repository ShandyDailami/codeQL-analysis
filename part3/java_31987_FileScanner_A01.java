import java.io.File;
import java.util.Scanner;

public class java_31987_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("test.txt");

        try {
            if (!file.canRead()) {
                throw new SecurityException("Cannot read file. File must be readable.");
            }

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}