import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22855_FileScanner_A08 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner(new File("."), true);
        try (Scanner fileScanner = new Scanner(new File("."))) {
            while (fileScanner.hasNextLine()) {
                String filename = fileScanner.nextLine();
                File file = new File(filename);
                if (file.canRead() && !file.isHidden() && file.canExecute()) {
                    scanner.scanFile(file);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class FileScanner {
    private File file;
    private boolean integrityCheck;

    public java_22855_FileScanner_A08(File file, boolean integrityCheck) {
        this.file = file;
        this.integrityCheck = integrityCheck;
    }

    public void scanFile(File file) {
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Do something with the line
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}