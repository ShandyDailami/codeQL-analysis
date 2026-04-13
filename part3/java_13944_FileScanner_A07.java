import java.io.File;
import java.util.Scanner;

public class java_13944_FileScanner_A07 {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        File file = new File(currentDir + "/example.txt");
        Scanner scanner = new Scanner(file);

        // This will loop through each line of the file
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        // Don't forget to close the scanner after usage
        scanner.close();
    }
}