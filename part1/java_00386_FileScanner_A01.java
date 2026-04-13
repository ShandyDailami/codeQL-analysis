import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00386_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner object
        FileScanner fs = new FileScanner();

        // Use the scan method to scan for files in the current directory
        fs.scan(".", ".*\\.txt$");
    }

    static class FileScanner {
        // The file we are looking to read
        File file;

        // Constructor
        FileScanner() throws FileNotFoundException {
            file = new File(".");
        }

        // Scan method to scan a directory
        void scan(String path, String regex) throws FileNotFoundException {
            File dir = new File(path);
            File[] listOfFiles = dir.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile() && file.canRead() && file.getName().matches(regex)) {
                    readFile(file);
                } else if (file.isDirectory()) {
                    scan(file.getPath(), regex);
                }
            }
        }

        // Method to read a file
        void readFile(File file) throws FileNotFoundException {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        }
    }
}