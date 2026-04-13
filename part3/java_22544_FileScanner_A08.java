import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22544_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String[] list = directory.list();

        if (list != null) {
            for (String fileName : list) {
                File file = new File(fileName);
                if (file.isFile() && file.canRead()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                }
            }
        }
    }
}