import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39057_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "/path/to/your/directory"; // replace with your directory
        File directory = new File(path);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Here you can perform security-sensitive operations related to A03_Injection, like SQL Injection or cross-site scripting
                        // For example, you can print the line to console, or you can execute commands in this context
                        System.out.println(line);
                    }
                    scanner.close();
                }
            }
        }
    }
}