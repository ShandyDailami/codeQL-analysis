import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34266_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String[] list = directory.list();
        
        if (list != null) {
            for (String filename : list) {
                File file = new File(filename);
                if (file.isFile() && file.canRead()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                }
            }
        }
    }
}