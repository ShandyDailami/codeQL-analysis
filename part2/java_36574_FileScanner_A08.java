import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36574_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";  // replace with your directory
        File directory = new File(directoryPath);

        File[] allFiles = directory.listFiles();

        for (File file : allFiles) {
            if (file.isFile()) {
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