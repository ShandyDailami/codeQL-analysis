import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08672_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "path_to_your_directory"; // replace with your directory path
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}