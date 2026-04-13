import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31253_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/path/to/file"; // replace with your actual path
        File file = new File(path);

        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}