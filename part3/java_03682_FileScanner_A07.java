import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03682_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "A07_AuthFailure.txt"; // Name of the file to search
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }
}