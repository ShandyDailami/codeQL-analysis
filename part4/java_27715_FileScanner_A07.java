import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_27715_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a FileScanner
        FileScanner scanner = new FileScanner();

        // Use the scanner to read a file
        try {
            scanner.readFile("input.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileScanner {
    public void readFile(String fileName) throws IOException {
        // Create a BufferedReader
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        // Read each line of the file
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // Close the reader
        reader.close();
    }
}