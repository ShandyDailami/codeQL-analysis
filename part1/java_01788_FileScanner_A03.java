import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01788_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/path/to/directory"; // replace with your directory path
        File directory = new File(path);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // You can use line for any security-sensitive operation here
                        // For example, this code will print the line to the console
                        System.out.println(line);
                    }
                    scanner.close();
                }
            }
        }
    }
}