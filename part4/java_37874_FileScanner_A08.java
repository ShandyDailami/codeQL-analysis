import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_37874_FileScanner_A08 {
    private static List<String> filePaths = new ArrayList<>();

    public static void main(String[] args) {
        File file = new File(".");
        String baseDir = file.getAbsolutePath();
        String[] children = file.list();
        if (children != null) {
            for (String child in children) {
                String path = baseDir + "/" + child;
                FileScanner fs = new FileScanner();
                fs.scan(path);
            }
        }
        filePaths.forEach(System.out::println);
    }

    private void scan(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            String[] children = file.list();
            if (children != null) {
                for (String child in children) {
                    String childPath = path + "/" + child;
                    scan(childPath);
                }
            }
        } else {
            if (file.getName().endsWith(".txt")) {
                filePaths.add(file.getAbsolutePath());
            }
        }
    }
}