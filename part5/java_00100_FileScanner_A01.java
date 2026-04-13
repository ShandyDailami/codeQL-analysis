import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00100_FileScanner_A01 {

    private File file;

    public java_00100_FileScanner_A01(String filePath) {
        this.file = new File(filePath);
    }

    public void scanFile() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line); // Uncommenting this line would print the file content
                // Breaking the loop after printing a line for demonstration purpose
                break;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        BrokenAccessControlScanner scanner = new BrokenAccessControlScanner("broken_access_control.txt");
        scanner.scanFile();
    }
}