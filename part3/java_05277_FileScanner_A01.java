import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05277_FileScanner_A01 {
    private File file;

    public java_05277_FileScanner_A01(String filePath) {
        file = new File(filePath);
    }

    public void readFile() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Remove comment using substring method
                String sanitizedLine = line.substring(0, line.indexOf('#'));
                System.out.println(sanitizedLine);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }

    public static void main(String[] args) {
        FileScanner fileScanner = new FileScanner("path/to/your/file");
        fileScanner.readFile();
    }
}