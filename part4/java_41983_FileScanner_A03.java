import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41983_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("."); // get current directory
        String[] list = directory.list();

        if (list == null) {
            System.out.println("No files or directories found in " + directory);
            return;
        }

        for (String fileName : list) {
            File file = new File(fileName);

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