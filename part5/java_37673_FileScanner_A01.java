import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37673_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("BrokenAccessControl.java")); // A01_BrokenAccessControl

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}