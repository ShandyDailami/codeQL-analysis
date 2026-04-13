import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12330_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("filename.txt"));  // line A1

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();  // line A2
                // print the line to prevent leaking of sensitive information
                System.out.println(line);
            }

            scanner.close();  // line A3

        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found.");
        }
    }
}