import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31642_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // process each line
                        // this is a place holder, don't forget to implement your security-sensitive operations related to A08_IntegrityFailure
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}