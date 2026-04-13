import java.io.File;
import java.util.Scanner;

public class java_02456_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_file");
            Scanner scanner = new Scanner(file);
            int lineNumber = 0;

            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();
                System.out.println("Line " + lineNumber + ": " + line);
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}