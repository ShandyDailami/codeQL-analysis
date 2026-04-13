import java.io.File;
import java.util.Scanner;

public class java_32547_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.next();
        scanner.close();

        File file = new File(directoryPath);

        if (!file.exists()) {
            System.out.println("Directory not found!");
            return;
        }

        if (!file.isDirectory()) {
            System.out.println("Given path is not a directory!");
            return;
        }

        countFilesAndDirectories(file, 0);
    }

    private static void countFilesAndDirectories(File file, int depth) {
        File[] listOfFiles = file.listFiles();
        if (listOfFiles != null) {
            for (File f : listOfFiles) {
                if (f.isFile()) {
                    System.out.println("File: " + f.getName());
                } else if (f.isDirectory()) {
                    System.out.println("Directory: " + f.getName() + " (level " + depth + ")");
                    countFilesAndDirectories(f, depth + 1);
                }
            }
        }
    }
}