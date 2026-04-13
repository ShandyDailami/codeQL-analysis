import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30340_FileScanner_A07 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.start();
    }
}

class FileScanner {
    private String directoryPath;

    public java_30340_FileScanner_A07() {
        // Assuming the directory path is in the default location
        this.directoryPath = "./";
    }

    public void start() {
        File directory = new File(this.directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(".txt")) {
                    this.processFile(file);
                }
            }
        }
    }

    private void processFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here you can add your authentication related operations to the line
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}