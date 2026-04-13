import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23827_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");

        String[] list = directory.list();

        for (String fileName : list) {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        }
    }
}