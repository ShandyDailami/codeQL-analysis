import java.io.File;
import java.util.Scanner;

public class java_03581_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);
        listFilesAndFolders(directory, 0);
    }

    private static void listFilesAndFolders(File directory, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        System.out.println(directory.getName());

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFilesAndFolders(file, level + 1);
                } else {
                    for (int i = 0; i < level; i++) {
                        System.out.print("--");
                    }
                    System.out.println(file.getName());
                }
            }
        }
    }
}