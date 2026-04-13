import java.io.File;
import java.util.Scanner;

public class java_05607_FileScanner_A01 {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory to scan (or press enter for current directory):");
        String directory = scanner.nextLine();

        File rootDirectory;

        // If user entered a directory, use that, else use current directory
        if (directory.isEmpty()) {
            rootDirectory = new File(currentDir);
        } else {
            rootDirectory = new File(directory);
        }

        printFiles(rootDirectory, 0);
    }

    private static void printFiles(File dir, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }

        System.out.println(dir.getName());

        File[] files = dir.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                printFiles(file, indentation + 1);
            }
        }
    }
}