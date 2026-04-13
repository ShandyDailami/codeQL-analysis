import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileFilter;

public class java_25452_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory to search:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("The path is not valid!");
            return;
        }

        System.out.println("Searching for files...");

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };

        File[] files = dir.listFiles(filter);

        if (files == null) {
            System.out.println("No .txt files found!");
            return;
        }

        for (File file : files) {
            System.out.println("File found: " + file.getPath());
        }
    }
}