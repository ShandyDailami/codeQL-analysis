import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07283_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_file"); // replace with your file path
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("sensitive_string")) {
                    System.out.println("File contains sensitive string: " + line);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}