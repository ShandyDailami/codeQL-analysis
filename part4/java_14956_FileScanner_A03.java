import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14956_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            printFiles(directory, 0);
        } else {
            System.out.println("Invalid directory path");
        }
    }

    private static void printFiles(File directory, int indentation) {
        File[] files = directory.listFiles();

        for (int i = 0; i < files.length; i++) {
            File file = files[i];

            if (file.isDirectory()) {
                printFiles(file, indentation + 1);
            } else {
                printLine(file, indentation);
            }
        }
    }

    private static void printLine(File file, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }

        System.out.println(file.getName());
    }
}