import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26532_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/security-sensitive-file.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Security-sensitive operation here
                // For example, we'll just print the line to the console
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}