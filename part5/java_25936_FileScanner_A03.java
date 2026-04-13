import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_25936_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");

        try (Scanner scanner = new Scanner(directory.listFiles())) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNext()) {
                        System.out.println(fileScanner.nextLine());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}