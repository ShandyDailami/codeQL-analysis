import java.io.File;
import java.util.Scanner;

public class java_40240_FileScanner_A03 {

    public static void main(String[] args) {
        File directory = new File(".");

        // Use a FileFilter to only scan .txt files
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                Scanner scanner = new Scanner(txtFile);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }
        }
    }
}