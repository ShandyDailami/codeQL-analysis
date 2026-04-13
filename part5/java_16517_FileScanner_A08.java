import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16517_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        String integrityFailure = "A08_IntegrityFailure";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the directory path:");
            directory = new File(scanner.next());
            System.out.println("Enter the integrity failure string:");
            integrityFailure = scanner.next();
        } catch (FileNotFoundException e) {
            System.out.println("Invalid directory path.");
            return;
        }

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().contains(integrityFailure)) {
                    System.out.println("File: " + file.getName());
                }
            }
        }
    }
}