import java.io.File;
import java.util.Scanner;

public class java_14925_FileScanner_A01 {

    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_file"); // replace with your file path
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}