import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12006_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("C:\\path\\to\\directory");
        String extension = ".txt";

        File[] listOfFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Here you can add security-sensitive operations related to A03_Injection
                    // For instance, you can add a sanitization operation to prevent SQL injection attacks
                    System.out.println(line);
                }
                scanner.close();
            }
        }
    }
}