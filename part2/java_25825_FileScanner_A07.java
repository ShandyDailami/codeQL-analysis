import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25825_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("yourFilePath"); // Replace with your file path
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("AuthFailure")) {
                    System.out.println("AuthFailure log found: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}