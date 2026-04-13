import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_28522_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("README.md")); // This is a hypothetical file

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine()); // Prints each line in the file
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}