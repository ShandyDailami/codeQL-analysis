import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25258_FileScanner_A03 {
    private Scanner scanner;

    public java_25258_FileScanner_A03(String filePath) throws FileNotFoundException {
        this.scanner = new Scanner(new File(filePath));
    }

    public void scan() {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Perform security sensitive operation here
            // For simplicity, we're just printing the line.
            System.out.println(line);
        }
    }
}