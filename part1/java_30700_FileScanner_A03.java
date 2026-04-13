import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30700_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        printFilesInDirectory(dir);
    }

    private static void printFilesInDirectory(File dir) {
        if (dir.listFiles() == null) {
            return;
        }

        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                printFilesInDirectory(file);
            }
        }
    }
}