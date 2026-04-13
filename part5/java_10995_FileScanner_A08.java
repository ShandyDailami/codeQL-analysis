import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10995_FileScanner_A08 {
    private String directory;

    public java_10995_FileScanner_A08(String directory) {
        this.directory = directory;
    }

    public void scanDirectory() {
        File dir = new File(directory);
        File[] listOfFiles = dir.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && isFileIntegrityOk(file)) {
                    System.out.println("File " + file.getName() + " has integrity OK");
                } else if (file.isDirectory()) {
                    System.out.println("Directory " + file.getName() + " has integrity problems");
                    scanDirectory();
                }
            }
        }
    }

    private boolean isFileIntegrityOk(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!isLineIntegrityOk(line)) {
                    return false;
                }
            }
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    private boolean isLineIntegrityOk(String line) {
        // Implement your security sensitive operation here.
        // For example, you can check if the line contains a specific pattern or a specific character.
        return true;
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner("/path/to/directory");
        scanner.scanDirectory();
    }
}