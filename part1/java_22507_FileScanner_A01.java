import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22507_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        printFilesInDirectory(directory, 0);
    }

    private static void printFilesInDirectory(File directory, int depth) {
        if (depth == 0) {
            System.out.println("------------------------");
        }
        System.out.println(directory.getAbsolutePath());

        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println(getIndentation(depth) + file.getName());
            } else if (file.isDirectory()) {
                printFilesInDirectory(file, depth + 1);
            }
        }
    }

    private static String getIndentation(int depth) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indentation.append("    ");
        }
        return indentation.toString();
    }
}