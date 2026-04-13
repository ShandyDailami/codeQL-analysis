import java.io.File;
import java.util.Scanner;

public class java_27074_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && !file.getName().equals("AuthFailure.java")) {
                    System.out.println(file.getPath());
                } else if (file.isDirectory() && !file.getName().equals("AuthFailure")) {
                    listFilesRecursively(file);
                }
            }
        }

        scanner.close();
    }

    private static void listFilesRecursively(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && !file.getName().equals("AuthFailure.java")) {
                    System.out.println(file.getPath());
                } else if (file.isDirectory() && !file.getName().equals("AuthFailure")) {
                    listFilesRecursively(file);
                }
            }
        }
    }
}