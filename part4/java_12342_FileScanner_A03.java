import java.io.File;
import java.util.Scanner;

public class java_12342_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String pattern = ".txt";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(pattern));

        if (files != null) {
            for (File file : files) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // perform security-sensitive operations related to A03_Injection
                    System.out.println(line);
                }
                scanner.close();
            }
        }
    }
}