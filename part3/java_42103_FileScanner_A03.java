import java.io.File;
import java.io.IOException;
import java.security.PrivilegedAction;

public class java_42103_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File(".");
        scanFile(file);
    }

    private static void scanFile(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File f : listFiles) {
                if (f.isFile()) {
                    System.out.println("File: " + f.getAbsolutePath());
                } else if (f.isDirectory()) {
                    System.out.println("Directory: " + f.getAbsolutePath());
                    scanFile(f);
                }
            }
        }
    }
}