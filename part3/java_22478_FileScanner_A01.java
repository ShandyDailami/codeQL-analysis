import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22478_FileScanner_A01 {
    private Scanner scanner;

    public java_22478_FileScanner_A01(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        scanner = new Scanner(file);
    }

    public String nextLine() {
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        } else {
            return null;
        }
    }

    public void close() {
        scanner.close();
    }
}