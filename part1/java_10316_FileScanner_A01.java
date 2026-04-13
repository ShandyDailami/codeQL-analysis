import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10316_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "/path/to/your/file";
        File file = new File(filePath);

        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } else {
            System.out.println("File not found: " + filePath);
        }
    }
}