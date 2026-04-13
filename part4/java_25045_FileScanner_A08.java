import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25045_FileScanner_A08 {

    public static void main(String[] args) {

        try {
            File file = new File("path_to_file");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A08_IntegrityFailure")) {
                    System.out.println("Found security-sensitive operation related to A08_IntegrityFailure!");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}