import java.io.File;
import java.util.Scanner;

public class java_06440_FileScanner_A01 {

    private String directoryPath;
    private File directory;

    public java_06440_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
        this.directory = new File(directoryPath);
    }

    public void scanDirectory() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    handleFile(file);
                } else if (file.isDirectory()) {
                    scanDirectory();
                }
            }
        }
    }

    private void handleFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("password")) {
                    System.out.println("Suspicious activity detected in file: " + file.getName());
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error handling file: " + file.getName());
        }
    }

    public static void main(String[] args) {
        UniqueVanillaFileScanner scanner = new UniqueVanillaFileScanner("/path/to/directory");
        scanner.scanDirectory();
    }
}