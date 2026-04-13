import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06658_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File(".");
        printFilesInDirectory(dir, 0);
    }

    private static void printFilesInDirectory(File dir, int indent) throws FileNotFoundException {
        for (int i = 0; i < indent; i++) {
            System.out.print("- ");
        }
        System.out.println(dir.getName());

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file, indent + 1);
                } else {
                    for (int i = 0; i < indent; i++) {
                        System.out.print("- ");
                    }
                    System.out.println(file.getName());
                }
            }
        }
    }
}