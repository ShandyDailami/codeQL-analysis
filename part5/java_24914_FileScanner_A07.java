import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24914_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path/to/auth/failure/file"); // replace with your file path
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here you could add the code to check for authentication failure in the line
                // For now, I will just print the line
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}