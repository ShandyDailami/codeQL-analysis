import java.io.File;
import java.util.Scanner;

public class java_18451_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String dir = scanner.next();

        File file = new File(dir);

        printFiles(file, "");
    }

    private static void printFiles(File file, String path) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    printFiles(f, path + f.getName() + "/");
                } else {
                    System.out.println(path + f.getName());
                }
            }
        }
    }
}