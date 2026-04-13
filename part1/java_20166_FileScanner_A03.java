import java.io.File;
import java.util.Scanner;

public class java_20166_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            scanDirectory(dir, 1);
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }

    private static void scanDirectory(File dir, int depth) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Print directory and indentation for depth.
                    System.out.println(getIndentation(depth) + file.getName() + "/");
                    // Recursive call for directory.
                    scanDirectory(file, depth + 1);
                } else {
                    // Print file and size.
                    System.out.println(getIndentation(depth) + file.getName() + " (Size: " + file.length() + ")");
                }
            }
        }
    }

    private static String getIndentation(int depth) {
        StringBuilder indentation = new StringBuilder();

        for (int i = 0; i < depth; i++) {
            indentation.append("--");
        }

        return indentation.toString();
    }
}