import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33329_FileScanner_A01 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory(".", ".*\\.txt$");
    }

    public void scanDirectory(String directoryPath, String filePattern) {
        File directory = new File(directoryPath);
        File[] directoryFiles = directory.listFiles();

        if (directoryFiles == null) {
            System.out.println("No files or directories found!");
            return;
        }

        for (File file : directoryFiles) {
            if (file.getName().matches(filePattern)) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Error accessing file: " + file.getPath());
                    e.printStackTrace();
                }
            }
        }
    }
}