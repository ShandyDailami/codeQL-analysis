import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class java_23986_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            System.exit(1);
        }

        if (!dir.canRead()) {
            System.out.println("Cannot read directory!");
            System.exit(1);
        }

        printFilesInDirectory(dir, "");
    }

    private static void printFilesInDirectory(File dir, String indent) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indent + "Dir: " + file.getName());
                    printFilesInDirectory(file, indent + "  ");
                } else {
                    System.out.println(indent + "File: " + file.getName());
                }
            }
        }
    }
}