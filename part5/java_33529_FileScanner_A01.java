import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33529_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/main/resources/access_control_file.txt"));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            // In a real-world application, you'd want to handle this line, for example, by logging it or executing some operation
            System.out.println("Line read from file: " + line);
        }
        fileScanner.close();
    }
}