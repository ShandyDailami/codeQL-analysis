import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12152_FileScanner_A03 {
    public static void main(String[] args) {
        // Scan the directory for all files
        File directory = new File(".");
        File[] files = directory.listFiles();

        // If files exists, print them out
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        System.out.println("File: " + file.getName());
                        System.out.println("Contents:");
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                        System.out.println();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}