import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38219_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File(".");
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Scanning files in directory: " + file.getAbsolutePath());
            } else {
                System.out.println("Not a directory: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("Invalid file or directory: " + file.getAbsolutePath());
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length() > 100) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
            e.printStackTrace();
        }
    }
}