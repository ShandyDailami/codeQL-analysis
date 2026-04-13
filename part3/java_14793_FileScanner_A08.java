import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14793_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");

        // Scan all files in the current directory
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isFile() && f.canRead() && f.length() > 1000) {
                    try {
                        Scanner scanner = new Scanner(f);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}