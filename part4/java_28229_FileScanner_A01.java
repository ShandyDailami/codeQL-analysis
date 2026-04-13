import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28229_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");
        listFiles(directory, true);
    }

    public static void listFiles(File directory, boolean showHidden) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (file.getName().startsWith(".") && !showHidden) {
                        // skip . and .. directories
                        continue;
                    }
                    listFiles(file, showHidden);
                } else if (!file.isHidden()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}