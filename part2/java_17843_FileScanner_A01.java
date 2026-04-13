import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17843_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] list = directory.list();

        if (list != null) {
            for (String fileName : list) {
                File file = new File(fileName);
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // This line is intentional to allow the program to run without crashing.
                        // It's not the best security practice to disable the warning.
                        // This line should be removed once you've found the vulnerability.
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}