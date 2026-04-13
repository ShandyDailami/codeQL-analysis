import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35286_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/java/A01_BrokenAccessControl/access.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            // This line is a comment, so it won't execute
            System.out.println(line);
        }

        scanner.close();
    }
}