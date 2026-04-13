import java.io.File;

public class java_21437_FileScanner_A08 {
    public static void main(String[] args) {
        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println("Root directory: " + root.getAbsolutePath());
            File[] files = root.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("  File: " + file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        System.out.println("  Directory: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }
}