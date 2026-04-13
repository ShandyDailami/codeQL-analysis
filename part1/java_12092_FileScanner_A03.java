import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12092_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        printFileNames(directory, filter);
    }

    private static void printFileNames(File directory, FileFilter filter) {
        File[] matchingFiles = directory.listFiles(filter);
        if (matchingFiles == null) return;

        for (File file : matchingFiles) {
            System.out.println(file.getName());
        }
    }
}