import java.io.File;
import java.util.Scanner;

public class java_36493_FileScanner_A08 {

    private File file;

    public java_36493_FileScanner_A08(String filePath) {
        file = new File(filePath);
    }

    public void scanFile() {
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } else {
            System.out.println("File does not exist.");
        }
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner("path/to/your/file");
        scanner.scanFile();
    }
}