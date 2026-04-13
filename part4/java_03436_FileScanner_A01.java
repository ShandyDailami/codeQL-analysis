import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03436_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/test.txt");
        Scanner scanner = new Scanner(file);

        System.out.println("Reading the file: ");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}