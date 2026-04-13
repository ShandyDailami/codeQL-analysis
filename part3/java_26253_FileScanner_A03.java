import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_26253_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("src/example.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            System.exit(1);
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}