import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08510_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("."); // Current directory
        File[] foundFiles = directory.listFiles();
        
        for (File file : foundFiles) {
            if (file.isFile()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }
        }
    }
}