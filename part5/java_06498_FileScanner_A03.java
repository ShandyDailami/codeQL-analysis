import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06498_FileScanner_A03 {

    private static final String DIRECTORY_PATH = "/path/to/directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Scanner scanner = null;
                    try {
                        scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Do something with the line (e.g., check for injection attempts)
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } finally {
                        if (scanner != null) {
                            scanner.close();
                        }
                    }
                }
            }
        }
    }
}