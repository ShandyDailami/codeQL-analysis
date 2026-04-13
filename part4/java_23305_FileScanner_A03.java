import java.io.File;
import java.util.Scanner;

public class java_23305_FileScanner_A03 {
    static final String DIRECTORY = "/path/to/directory";
    static final String EXTENSION = ".ext";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(EXTENSION));

        if (files != null) {
            for (File file : files) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
               
                }
                scanner.close();
            }
        }
    }
}