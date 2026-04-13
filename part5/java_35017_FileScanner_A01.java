import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35017_FileScanner_A01 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("BrokenAccessControl.java")); // A01_BrokenAccessControl

            // Scanner reads file line by line, so we can't read all content at once
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // A01_BrokenAccessControl
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}