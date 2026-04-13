import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36302_FileScanner_A03 {

    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        scanDirectory(currentDir);
    }

    public static void scanDirectory(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // If the file is a text file
                    if (file.getName().endsWith(".txt")) {
                        scanFile(file);
                    }
                } else if (file.isDirectory()) {
                    // If the file is a directory
                    scanDirectory(file.getPath());
                }
            }
        }
    }

    public static void scanFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}