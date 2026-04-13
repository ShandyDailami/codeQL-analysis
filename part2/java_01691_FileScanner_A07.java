import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_01691_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_file"); // replace with your file path
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // print the content of the file
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}