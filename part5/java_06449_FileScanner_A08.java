import java.io.File;
import java.security.Permission;
import java.security.SecureRandom;
import java.util.Scanner;

public class java_06449_FileScanner_A08 {
    private static final SecureRandom rand = new SecureRandom();
    private static final String ALPHANUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static void main(String[] args) {
        File file = new File(".");
        scanFile(file, 0);
    }

    private static void scanFile(File file, int depth) {
        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }

        if (file.isDirectory()) {
            if (depth == 0) {
                System.out.println("\nDirectories:");
            }
            String[] files = file.list();
            if (files != null) {
                for (String s : files) {
                    scanFile(new File(file.getPath() + "/" + s), depth);
                }
            }
        } else {
            if (depth == 0) {
                System.out.println("\nFiles:");
            }
            if (file.getName().endsWith(".txt")) {
                System.out.println(file.getPath());
            }
        }
    }
}