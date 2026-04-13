import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21235_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("target/file.txt"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}