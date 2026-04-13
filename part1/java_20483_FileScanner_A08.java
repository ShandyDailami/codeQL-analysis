import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20483_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner object to read files
        FileScanner fileScanner = new FileScanner();

        // Test the readFile method
        fileScanner.readFile(new File("test.txt"));
    }

    // Declare FileScanner class
    private class FileScanner {
        // Declare a method to read a file
        public void readFile(File file) throws FileNotFoundException {
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Here, you might add some logic to check the integrity of the file.
                    // For now, let's just print the line.
                    System.out.println(line);
                }
                scanner.close();
            } else {
                throw new FileNotFoundException("File not found");
            }
        }
    }
}