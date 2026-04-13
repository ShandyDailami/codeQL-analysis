import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21851_FileScanner_A07 {

    private static final int MAX_DEPTH = 3;
    private static String searchString = "A07_AuthFailure";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        searchInDirectory(new File(directoryPath), MAX_DEPTH);
    }

    private static void searchInDirectory(File directory, int depth) {
        if (depth <= 0 || !directory.exists() || !directory.isDirectory()) {
            return;
        }

        if (directory.getName().startsWith(searchString)) {
            System.out.println("Found file: " + directory.getPath());
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchInDirectory(file, depth - 1);
                }
            }
        }
    }
}