import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06847_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "A07_AuthFailure.txt"; // replace with the file you want to search
        File file = new File(fileName);

        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } else {
            System.out.println("File not found: " + fileName);
        }
    }
}