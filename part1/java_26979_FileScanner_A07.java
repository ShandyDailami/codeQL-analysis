import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26979_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);
        printFilesInDirectory(dir, 0);
    }

    private static void printFilesInDirectory(File dir, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.println(dir.getName());

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file, indent + 1);
                } else {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}