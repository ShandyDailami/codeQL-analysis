import java.io.File;
import java.util.Scanner;

public class java_41294_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();

        File file = new File(directoryPath);
        File[] listFiles = file.listFiles();

        for (File listFile : listFiles) {
            if (listFile.isDirectory()) {
                System.out.println("Directory: " + listFile.getName());
                printFileCount(listFile);
            }
        }

        scanner.close();
    }

    private static void printFileCount(File file) {
        File[] listFiles = file.listFiles();
        int count = 0;
        for (File listFile : listFiles) {
            if (listFile.isFile()) {
                count++;
            }
        }
        System.out.println("Number of files: " + count);
    }
}