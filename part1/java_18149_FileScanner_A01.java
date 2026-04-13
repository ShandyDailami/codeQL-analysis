import java.io.File;
import java.util.Scanner;

public class java_18149_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a new Scanner for standard input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.println("Enter the path to scan:");
        String path = scanner.nextLine();

        // Create a new File object and set the path
        File file = new File(path);

        // List the roots
        File[] roots = file.listRoots();

        if (roots != null) {
            for (File root : roots) {
                System.out.println("Root: " + root.getAbsolutePath());

                File[] files = root.listFiles();

                if (files != null) {
                    for (File f : files) {
                        System.out.println("File: " + f.getAbsolutePath());
                    }
                }
            }
        }
    }
}