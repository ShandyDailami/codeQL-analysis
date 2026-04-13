import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25614_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("myFile.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
            return;
        }

        System.out.println("Searching for 'A08_IntegrityFailure' in the file: " + file.getName());

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("A08_IntegrityFailure")) {
                System.out.println("Found: " + line);
            }
        }

        scanner.close();
    }
}