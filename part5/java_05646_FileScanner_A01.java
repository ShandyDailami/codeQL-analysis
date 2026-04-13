import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05646_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("src/main/resources/broken_access_control.txt"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println("Line read from file: " + line);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file 'broken_access_control.txt' was not found. Please check the file path.");
        }
    }
}