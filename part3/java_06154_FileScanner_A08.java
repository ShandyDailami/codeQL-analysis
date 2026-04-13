import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06154_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // replace with actual directory path
        File directory = new File(directoryPath);

        File[] allFiles = directory.listFiles();

        for (File file : allFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) { // check if it's a text file
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