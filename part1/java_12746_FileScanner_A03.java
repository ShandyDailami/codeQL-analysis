import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_12746_FileScanner_A03 {
    public static void main(String[] args) {
        // create the file object
        File file = new File("path_to_your_file");

        // make sure the file exists and is accessible
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            // use a while loop to read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}