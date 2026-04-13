import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30347_FileScanner_A07 {
    public static void main(String[] args) {
        String dirPath = "/path/to/directory";  // replace with your directory path
        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        try (Scanner scanner = new Scanner(dir)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}