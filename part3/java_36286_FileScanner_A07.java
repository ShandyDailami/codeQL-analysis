import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36286_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/legacy_files.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("File contents: " + line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}