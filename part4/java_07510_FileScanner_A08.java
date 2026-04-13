import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07510_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String dirPath = ".";
        File directory = new File(dirPath);
        File[] listOfFiles = directory.listFiles();

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