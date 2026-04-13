import java.io.*;

public class java_39460_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");
        printFilesAndDirectories(file, 0);
    }

    private static void printFilesAndDirectories(File file, int indentation) {
        String spaces = "";
        for (int i = 0; i < indentation; i++) {
            spaces += "  ";
        }
        System.out.println(spaces + file.getName());

        File[] files = file.listFiles();
        if (files != null) {
            for (File file2 : files) {
                if (file2.isDirectory()) {
                    printFilesAndDirectories(file2, indentation + 1);
                } else {
                    System.out.println(spaces + "  " + file2.getName());
                }
            }
        }
    }
}