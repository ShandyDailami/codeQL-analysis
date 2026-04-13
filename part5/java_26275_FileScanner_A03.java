import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26275_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        String directory = "C:\\temp"; // Specify your directory here
        File dir = new File(directory);

        if (dir.exists()) {
            File[] txtFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    Scanner scanner = new Scanner(txtFile);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println("Line: " + line);
                    }
                    scanner.close();
                }
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }
}