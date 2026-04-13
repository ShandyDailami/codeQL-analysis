import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10078_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");

        // use try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(directory.listFiles())) {
            while (scanner.hasNext()) {
                String filename = scanner.next();
                try (Scanner fileScanner = new Scanner(new File(filename))) {
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