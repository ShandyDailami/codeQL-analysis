import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03590_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        long count = countFiles(directory);
        System.out.println("Number of files with extension .txt in " + directory.getAbsolutePath() + ": " + count);
    }

    public static long countFiles(File directory) throws FileNotFoundException {
        long count = 0;
        if (directory.listFiles() != null) {
            for (File file : directory.listFiles()) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    count++;
                } else if (file.isDirectory()) {
                    count += countFiles(file);
                }
            }
        }
        return count;
    }
}