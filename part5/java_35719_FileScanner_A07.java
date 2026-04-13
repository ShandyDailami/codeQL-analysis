import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_35719_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a FileScanner
        FileScanner scanner = new FileScanner();

        // Try to open the file
        try {
            scanner.open("test.txt");
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
            return;
        }

        // Read each line
        String line;
        try {
            while ((line = scanner.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            // Always close the file
            scanner.close();
        }
    }
}

class FileScanner {
    private BufferedReader reader;

    public void open(String filename) throws IOException {
        reader = new BufferedReader(new FileReader(filename));
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    public void close() throws IOException {
        reader.close();
    }
}