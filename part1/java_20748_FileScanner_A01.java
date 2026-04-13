import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20748_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("path/to/file");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is where you would potentially perform a security sensitive operation
                // For instance, we'll assume we're attempting to open a file and read it
                File readFile = new File(line);
                Scanner fileScanner = new Scanner(readFile);
                while (fileScanner.hasNextLine()) {
                    String readLine = fileScanner.nextLine();
                    System.out.println(readLine);
                }
                fileScanner.close();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}