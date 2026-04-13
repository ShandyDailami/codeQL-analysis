import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09006_FileScanner_A08 {
    private File file;

    public java_09006_FileScanner_A08(String filePath) {
        this.file = new File(filePath);
    }

    public void scanFile() {
        if (file.exists()) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Add your security-sensitive operations here
                    System.out.println(line);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found.");
        }
    }
}