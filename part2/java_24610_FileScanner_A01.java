import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24610_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        String dirPath = "/path/to/your/directory"; // Replace with your directory path
        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}