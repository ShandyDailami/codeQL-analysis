import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20558_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/your/directory";
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                }
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }
}