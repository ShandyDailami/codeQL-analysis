import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39393_FileScanner_A08 {
    private static final String DIR = "src/main/resources";
    private static final String FILE_EXTENSION = ".txt";

    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File(DIR);
        File[] files = dir.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

        if (files != null) {
            for (File file : files) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Perform security-sensitive operations related to A08_IntegrityFailure here
                    System.out.println(line);
                }
                scanner.close();
            }
        }
    }
}