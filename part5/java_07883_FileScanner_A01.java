import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07883_FileScanner_A01 {
    private static final String TXT_EXTENSION = ".txt";
    private static final int MAX_DEPTH = 1;

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        int depth = 0;

        File directory = new File(directoryPath);
        Scanner scanner = new Scanner(System.in);

        scanFiles(directory, depth, scanner);
    }

    private static void scanFiles(File directory, int depth, Scanner scanner) {
        if (depth > MAX_DEPTH) {
            return;
        }

        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(TXT_EXTENSION)) {
                System.out.println("Found text file: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Found directory: " + file.getName());
                scanFiles(file, depth + 1, scanner);
            }
        }
    }
}