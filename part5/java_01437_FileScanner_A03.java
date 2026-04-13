import java.io.File;
import java.util.Scanner;

public class java_01437_FileScanner_A03 {
    private static final String DIRECTORY_PATH = "path_to_your_directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        secureFileCheck(file);
                    }
                }
            }
        }
    }

    private static void secureFileCheck(File file) {
        try {
            // Reading file in secure way
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}