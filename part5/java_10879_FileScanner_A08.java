import java.io.File;
import java.util.Scanner;

public class java_10879_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.next();
        scanner.close();

        File file = new File(path);

        if (file.exists()) {
            listFiles(file, "");
        } else {
            System.out.println("The specified path does not exist!");
        }
    }

    private static void listFiles(File file, String prefix) {
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    listFiles(f, prefix + "/" + f.getName());
                } else {
                    System.out.println(prefix + "/" + f.getName());
                }
            }
        }
    }
}