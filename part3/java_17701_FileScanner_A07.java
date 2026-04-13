import java.io.File;
import java.io.FilenameFilter;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17701_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {

        File currentDir = new File(".");

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith("java");
            }
        };

        findJavaFiles(currentDir, fileFilter);
    }

    private static void findJavaFiles(File dir, FileFilter fileFilter) throws FileNotFoundException {
        File[] files = dir.listFiles(fileFilter);

        if (files == null) return;

        for (File file : files) {
            if (file.isFile()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println("File: " + file.getAbsolutePath() + ", Line: " + line);
                }
                scanner.close();
            } else if (file.isDirectory()) {
                findJavaFiles(file, fileFilter);
            }
        }
    }
}