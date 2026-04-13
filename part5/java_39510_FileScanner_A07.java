import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39510_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File("path/to/your/file");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
            System.exit(1);
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("AUTH_FAILURE")) {
                System.out.println("Auth failure detected: " + line);
            }
        }

        scanner.close();
    }

}