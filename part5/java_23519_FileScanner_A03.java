import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23519_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        String currentDir = new File(".").getCanonicalPath();
        File file = new File(currentDir + "/a.txt");
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } else {
            System.out.println("File not found in current directory.");
        }
    }
}