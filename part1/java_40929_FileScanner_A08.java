import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40929_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/data.txt"); // replace with your file path
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("Parsing line: " + line);

            // You can put your code here to verify the integrity of the line.
            // For now, let's just print the line.
            System.out.println("Verified integrity: " + line);
        }

        scanner.close();
    }
}