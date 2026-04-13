import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Scanner;

public class java_24061_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("The specified path does not exist or is not a directory");
            return;
        }

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };

        System.out.println("Files in directory " + dir.getPath() + ":");
        File[] list = dir.listFiles(filter);
        if (list == null) return;

        for (File file : list) {
            if (file.isFile()) {
                System.out.println("File: " + file.getPath());
                System.out.println("Size: " + file.length() + " bytes");
            }
        }

        scanner.close();
    }
}