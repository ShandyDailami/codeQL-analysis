import java.io.File;
import java.util.Scanner;

public class java_26807_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File(".");

        // List all files and directories recursively
        listFiles(file, 0);
    }

    private static void listFiles(File file, int level) {
        // List file
        System.out.println(createIndentation(level) + file.getName());

        // If it's a directory, list all files in it recursively
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            if (list != null) {
                for (File f : list) {
                    listFiles(f, level + 1);
                }
            }
        }
    }

    private static String createIndentation(int level) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indentation.append("    ");
        }
        return indentation.toString();
    }
}