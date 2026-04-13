import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03916_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File startingDirectory = new File(".");

        FileFilter textFilesFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };

        findTextFiles(startingDirectory, textFilesFilter);
    }

    private static void findTextFiles(File startingDirectory, FileFilter textFilesFilter) throws FileNotFoundException {
        File[] files = startingDirectory.listFiles(textFilesFilter);

        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                findTextFiles(file, textFilesFilter);
            } else {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println("Found text file: " + file.getPath());
                }
                scanner.close();
            }
        }
    }
}