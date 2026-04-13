import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40663_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File("target/path-to-your-file.txt"); // replace with your file path
        Scanner scanner = null;
        int count = 0;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                if (scanner.next().equals("authFailure")) {
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        System.out.println("Count of 'authFailure': " + count);
    }

}