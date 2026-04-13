import java.io.*;
import java.util.Scanner;

public class java_01841_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a FileScanner instance
        FileScanner scanner = new FileScannerImpl();

        // Set the input file
        scanner.setFile("C:\\path\\to\\your\\file.txt");

        // Set the string to find
        scanner.setFindString("your string");

        // Start scanning
        scanner.startScanning();
    }
}

class FileScannerImpl extends FileScanner {
    private File file;
    private String findString;

    @Override
    public void setFile(String path) {
        file = new File(path);
    }

    @Override
    public void setFindString(String str) {
        findString = str;
    }

    @Override
    public void startScanning() {
        // Scan the file line by line
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Stop scanning if the find string is found
            if (line.contains(findString)) {
                break;
            }
            // Continue scanning the rest of the file
            else {
                System.out.println(line);
            }
        }
        scanner.close();
    }
}