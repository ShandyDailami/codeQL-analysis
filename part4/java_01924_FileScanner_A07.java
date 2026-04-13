import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01924_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File("path_to_file"); // replace with your file path
        Scanner scanner = null;
        try {
            scanner = new Scanner(file); // creating a scanner for file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("A07_AuthFailure")) {
                System.out.println("AuthFailure detected in line: " + line);
            }
        }
        scanner.close();
    }
}