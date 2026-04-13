import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17485_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/your/directory"); // replace with your directory path
        Scanner scanner = new Scanner(file);

        // Print each line in the file
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close();
    }
}