import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_31646_FileScanner_A01 {
    public static void main(String[] args) {
        // Start at the root directory
        File root = new File(".");
        printFiles(root, 0);
    }

    private static void printFiles(File file, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }
        System.out.println(file.getName());

        File[] list = file.listFiles();
        if (list == null) {
            return;
        }

        for (File f : list) {
            printFiles(f, indentation + 1);
        }
    }
}