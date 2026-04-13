import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11692_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/securityFile.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}