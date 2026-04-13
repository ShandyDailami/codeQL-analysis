import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_09776_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a new scanner for command line input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        // Get the list of root directories
        File[] roots = File.listRoots();

        // Print the list of root directories
        System.out.println("Available file systems: " + Arrays.toString(roots));

        // Print the content of each root directory
        for (File root : roots) {
            System.out.println("Content of " + root.getAbsolutePath() + ":");
            printDirectoryContents(root);
        }

        scanner.close();
    }

    private static void printDirectoryContents(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("  " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("  " + file.getName() + "/");
                    printDirectoryContents(file);
                }
            }
        }
    }
}