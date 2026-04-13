import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01366_FileScanner_A08 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/A08_IntegrityFailure.txt"));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                // Add integrity check code here
                // ...

                // For example, we'll just print the line to the console:
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            e.printStackTrace();
        }
    }
}