import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40029_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/file.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform some auth failure operation here

                // For example, we are just logging the line
                System.out.println("Processing line: " + line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}