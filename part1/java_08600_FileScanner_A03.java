import java.io.File;
import java.util.Scanner;

public class java_08600_FileScanner_A03 {
    public static void main(String[] args) {
        String currentDirPath = System.getProperty("user.dir");
        File currentDir = new File(currentDirPath);

        printFileNamesInDirectory(currentDir);
    }

    public static void printFileNamesInDirectory(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFileNamesInDirectory(file);
                }
            }
        }
    }
}