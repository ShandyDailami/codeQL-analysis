import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_29062_FileScanner_A08 {
    public static void main(String[] args) {
        // Creating a File instance
        File file = new File("path/to/your/file.txt");

        try {
            // Creating a Scanner instance
            Scanner scanner = new Scanner(file);

            // Using a while loop to read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Closing the Scanner instance
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}