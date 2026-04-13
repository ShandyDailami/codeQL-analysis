import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28352_FileScanner_A03 {
    // A simple file scanner that scans a directory for files
    // This is a very basic implementation and should not be used for real-world applications.
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String fileExtension = ".*txt";
        scanFiles(directoryPath, fileExtension);
    }

    private static void scanFiles(String directoryPath, String fileExtension) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        processFile(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void processFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Here you would ideally use a secure method to process the line
            // For simplicity, we'll just print the line
            System.out.println(line);
        }
        scanner.close();
    }
}