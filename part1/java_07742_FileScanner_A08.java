import java.io.File;
import java.util.Scanner;

public class java_07742_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.next();

        File file = new File(path);
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getName());
                } else if (f.isDirectory()) {
                    System.out.println(f.getName() + "/");
                    listFiles(f);
                }
            }
        }
        scanner.close();
    }

    public static void listFiles(File file) {
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println("   " + f.getName());
                } else if (f.isDirectory()) {
                    System.out.println("   " + f.getName() + "/");
                    listFiles(f);
                }
            }
        }
    }
}