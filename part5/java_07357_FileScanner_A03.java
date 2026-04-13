import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07357_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            printFilesInDirectory(directory);
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
}