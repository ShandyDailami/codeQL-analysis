import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28135_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // process line here
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}