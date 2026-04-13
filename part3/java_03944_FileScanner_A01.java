import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_03944_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            List<File> files = new ArrayList<>(file.listFiles());
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getAbsolutePath());
                } else if (f.isDirectory()) {
                    listDirectory(f, 1);
                }
            }
        } else {
            System.out.println("The directory does not exist.");
        }

        scanner.close();
    }

    private static void listDirectory(File directory, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print(" ");
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    listDirectory(file, indentation + 1);
                }
            }
        }
    }
}