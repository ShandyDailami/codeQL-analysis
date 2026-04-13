import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16159_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "src/main/resources"; // replace with your directory path
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile() && file.canRead()) {
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