import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40873_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        printFilesInDirectory(dir, 0);
    }

    private static void printFilesInDirectory(File directory, int indentation) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file, indentation + 1);
                } else {
                    printFile(file, indentation);
                }
            }
        }
    }

    private static void printFile(File file, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print(" ");
        }
        System.out.println(file.getName());
    }
}