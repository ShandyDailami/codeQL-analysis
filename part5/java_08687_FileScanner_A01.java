import java.io.File;
import java.util.Scanner;

public class java_08687_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        if (file.exists()) {
            findFiles(file);
        } else {
            System.out.println("Directory not found!");
        }
    }

    public static void findFiles(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getName());
                } else if (f.isDirectory()) {
                    findFiles(f);
                }
            }
        }
    }
}