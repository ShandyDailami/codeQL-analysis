import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24204_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File("example.txt"); // replace with your file path
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("sensitive operation")) {
                    System.out.println("Integrity failure detected in line: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}