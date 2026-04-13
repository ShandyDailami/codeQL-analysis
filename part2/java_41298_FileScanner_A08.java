import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41298_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("."); // get current directory
        Scanner scanner = null;

        try {
            scanner = new Scanner(file); // create a Scanner to read files
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // print each line
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close(); // close the Scanner
            }
        }
    }
}