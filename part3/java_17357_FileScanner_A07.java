import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17357_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";
        File dir = new File(directory);

        try {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println("File Content: " + line);
                        }
                        scanner.close();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}