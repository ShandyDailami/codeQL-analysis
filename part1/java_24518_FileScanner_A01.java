import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_24518_FileScanner_A01 {
    public static void main(String[] args) {
        File currentDirectory = new File(".");
        printFiles(currentDirectory, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        });
    }

    private static void printFiles(File dir, FileFilter filter) {
        File[] files = dir.listFiles(filter);
        if (files != null) {
            Arrays.stream(files).forEach(Main::printFile);
        }
    }

    private static void printFile(File file) {
        if (file.isDirectory()) {
            printFiles(file, filter);
        } else {
            System.out.println(file.getName());
        }
    }
}