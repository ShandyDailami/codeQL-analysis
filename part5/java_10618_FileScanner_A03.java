import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10618_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/example.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);

            // Remove this line if you want to prevent the program from reading the same file again
            scanner.close();
        }
    }
}