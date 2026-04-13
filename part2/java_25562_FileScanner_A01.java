import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25562_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            // Create a FileScanner object
            FileScanner scanner = new FileScanner();

            // Use the scanner to navigate through files
            scanner.navigateFiles(".", ".txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class FileScanner {
    private File file;

    public java_25562_FileScanner_A01() {
        this.file = new File(".");
    }

    public void navigateFiles(String dirPath, String extension) throws FileNotFoundException {
        File directory = new File(dirPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println("Line: " + line);
                    }
                    scanner.close();
                }
            }
        } else {
            System.out.println("Error: No files found in " + dirPath);
        }
    }
}