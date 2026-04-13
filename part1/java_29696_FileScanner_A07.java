import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29696_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String currentDir = System.getProperty("user.dir");
        File targetFile = new File(currentDir + "/target.txt");
        
        if (targetFile.exists()) {
            Scanner scanner = new Scanner(targetFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } else {
            System.out.println("Target file not found.");
        }
    }
}