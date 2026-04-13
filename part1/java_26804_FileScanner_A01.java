import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26804_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File folder = new File(".");
        File[] listOfFiles = folder.listFiles();
        
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
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