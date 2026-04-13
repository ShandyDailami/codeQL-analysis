import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01428_FileScanner_A08 {
    public static void main(String[] args) {
        String dirPath = "path/to/directory"; // replace with your directory path
        scanFilesInDirectory(dirPath);
    }

    public static void scanFilesInDirectory(String dirPath) {
        File directory = new File(dirPath);
        File[] allFiles = directory.listFiles();

        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile() && file.canRead()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // do something with the line here
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}