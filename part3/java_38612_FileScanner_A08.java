import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38612_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}