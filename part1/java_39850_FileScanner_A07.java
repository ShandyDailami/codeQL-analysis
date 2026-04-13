import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39850_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File[] files = new File(".").listFiles((dir, name) -> name.endsWith(".txt") && new File(dir, name).length() > 500);
        if (files != null) {
            for (File file : files) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }
        }
    }
}