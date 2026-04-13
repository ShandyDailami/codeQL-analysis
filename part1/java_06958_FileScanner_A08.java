import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06958_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path

        File startingDirectory = new File(directoryPath);
        findFilesWithPermissions(startingDirectory);
    }

    private static void findFilesWithPermissions(File directory) {
        File[] filesWithPermissions = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.canRead() && pathname.canWrite();
            }
        });

        for (File file : filesWithPermissions) {
            if (file.isDirectory()) {
                findFilesWithPermissions(file);
            } else {
                try {
                    Scanner scanner = new Scanner(file);
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