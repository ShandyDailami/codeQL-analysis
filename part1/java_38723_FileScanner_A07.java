import java.io.File;
import java.io.IOException;

public class java_38723_FileScanner_A07 {
    public static void main(String[] args) {
        File rootDir = new File("."); // Current directory

        printDirectoryContents(rootDir, 0);
    }

    private static void printDirectoryContents(File dir, int indent) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                for (int i = 0; i < indent; i++) {
                    System.out.print(" ");
                }

                if (file.isDirectory()) {
                    System.out.println(file.getName());
                    printDirectoryContents(file, indent + 1);
                } else {
                    System.out.println(file.getName());
                }
            }
        }
    }
}