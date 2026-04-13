import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33929_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        // Point to the file we want to read
        String filePath = "./src/main/resources/example.txt";
        File file = new File(filePath);

        // Check if file exists
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        // Scan the file
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }
}