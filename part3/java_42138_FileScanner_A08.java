import java.io.File;
import java.util.Scanner;

public class java_42138_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        printFilesInDirectory(directory, 0);
    }

    private static void printFilesInDirectory(File dir, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }

        System.out.println(dir.getName());

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file, indent + 1);
                } else {
                    System.out.println(getFilePrint(file, indent));
                }
            }
        }
    }

    private static String getFilePrint(File file, int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("  ");
        }
        sb.append(file.getName());
        return sb.toString();
    }
}