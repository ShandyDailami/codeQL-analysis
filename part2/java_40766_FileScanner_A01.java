import java.io.File;
import java.util.Scanner;

public class java_40766_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        // use File.listRoots() to get a list of file systems that could be used to scan the directory
        File[] fileSystems = File.listRoots();

        for (File fileSystem : fileSystems) {
            File dir = new File(fileSystem, dirPath);
            if (dir.exists() && dir.isDirectory()) {
                printDirectoryContents(dir);
            }
        }

        scanner.close();
    }

    private static void printDirectoryContents(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // check if file is secure (e.g. not accessible by external users)
                    if (file.getAbsolutePath().endsWith(".exe") || file.getAbsolutePath().endsWith(".jar")) {
                        System.out.println("Suspicious file: " + file.getAbsolutePath());
                    } else {
                        System.out.println(file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    printDirectoryContents(file);
                }
            }
        }
    }
}