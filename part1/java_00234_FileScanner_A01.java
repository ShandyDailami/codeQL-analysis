import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00234_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("."); // current directory

        // Get all files in the directory
        File[] files = directory.listFiles();

        // If files array is null, there are no files in the directory
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
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