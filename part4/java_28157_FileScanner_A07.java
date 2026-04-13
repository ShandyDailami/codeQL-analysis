import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_28157_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("auth.log");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("auth.log not found.");
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Searching for failed authentication attempts in auth.log:");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("Failed password for")) {
                System.out.println("Failed password attempt at " + line);
            }
        }
        scanner.close();
    }
}