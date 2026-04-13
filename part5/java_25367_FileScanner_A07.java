import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25367_FileScanner_A07 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/A07_AuthFailure.txt"));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                // Perform security-sensitive operations related to A07_AuthFailure here
                // For simplicity, we will print out the line just for now
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}