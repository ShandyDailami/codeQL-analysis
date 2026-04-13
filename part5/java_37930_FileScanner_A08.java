import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37930_FileScanner_A08 {

    public static void main(String[] args) {
        File directory = new File(".");

        try (Scanner scanner = new Scanner(directory.listFiles())) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}