import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03171_FileScanner_A01 {
    public static void main(String[] args) {
        String rootDirectory = "/path/to/directory"; // specify your directory here
        File rootFile = new File(rootDirectory);

        if (rootFile.exists()) {
            printFiles(rootFile, 0);
        } else {
            System.out.println("Directory does not exist: " + rootDirectory);
        }
    }

    private static void printFiles(File file, int indentationLevel) {
        for (int i = 0; i < indentationLevel; i++) {
            System.out.print("  ");
        }

        System.out.println("+ " + file.getPath());

        File[] files = file.listFiles();
        if (files != null) {
            for (File childFile : files) {
                printFiles(childFile, indentationLevel + 1);
            }
        }
    }
}