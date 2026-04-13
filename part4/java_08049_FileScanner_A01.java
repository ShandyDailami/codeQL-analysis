import java.io.File;
import java.util.Arrays;

public class java_08049_FileScanner_A01 {
    public static void main(String[] args) {
        File root = new File(".");
        listFiles(root, 0);
    }

    private static void listFiles(File directory, int level) {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                if (file.getName().equals("." + file.getName())) {
                    continue;
                }
                listFiles(file, level + 1);
            } else {
                printIndentation(level);
                System.out.println(file.getName());
            }
        }
    }

    private static void printIndentation(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        System.out.println("> " + level + " " + "Directory: " + level + " " + "File: " + level);
    }
}