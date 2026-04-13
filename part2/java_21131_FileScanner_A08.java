import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21131_FileScanner_A08 {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        File folder = new File(currentDir);

        scanDirectory(folder);
    }

    private static void scanDirectory(File directory) {
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    // You can add more security-sensitive operations here.
                    // For example, checking the file integrity.
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Do something with the line here.
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }
}