import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30766_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");

        try (Scanner scanner = new Scanner(directory.listFiles())) {
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                System.out.println(fileName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}