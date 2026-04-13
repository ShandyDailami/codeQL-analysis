import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_40434_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File directory = new File(".");
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNext()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}