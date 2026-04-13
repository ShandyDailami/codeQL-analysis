import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10819_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/auth.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("badPassword")) {
                System.out.println("Authentication failed due to incorrect password.");
                System.exit(1);
            }
        }

        if (scanner != null) {
            scanner.close();
        }
    }
}