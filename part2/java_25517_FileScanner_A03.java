import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25517_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "/path/to/your/file.txt"; // provide your file path

        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        // Read and print file content
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }

}