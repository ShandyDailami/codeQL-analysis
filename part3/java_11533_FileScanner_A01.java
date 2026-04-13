import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11533_FileScanner_A01 {
    private File file;
    private Scanner scanner;

    public java_11533_FileScanner_A01(String filePath) {
        file = new File(filePath);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public boolean hasNext() {
        return scanner.hasNext();
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}