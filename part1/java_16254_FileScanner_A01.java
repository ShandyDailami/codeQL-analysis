import java.io.File;
import java.util.Scanner;

public class java_16254_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            scanFilesInDirectory(directory, 0);
        } else {
            System.out.println("Directory does not exist!");
        }

        scanner.close();
    }

    private static void scanFilesInDirectory(File directory, int depth) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // If the file is a directory, recursively scan it.
                    scanFilesInDirectory(file, depth + 1);
                } else {
                    // If the file is a file, print its name.
                    printIndentation(depth);
                    System.out.println(file.getName());
                }
            }
        }
    }

    private static void printIndentation(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        System.out.print("> ");
    }
}