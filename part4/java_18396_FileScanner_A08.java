import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class java_18396_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        // File Scanner reads from a file
        File file = new File("file.txt");
        Scanner scanner = new Scanner(file);

        // File Writer writes to a file
        FileWriter writer = new FileWriter("file.txt");

        // Iterate over the file to verify integrity
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            writer.write(line + "\n");
        }

        // Close the scanners and writers
        scanner.close();
        writer.close();
    }
}