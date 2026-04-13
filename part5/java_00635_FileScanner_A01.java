import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00635_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
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