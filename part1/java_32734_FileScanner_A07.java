import java.io.File;
import java.util.Scanner;

public class java_32734_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            listFiles(directory, 0);
        } else {
            System.out.println("Directory not found.");
        }
    }

    private static void listFiles(File directory, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println("- " + directory.getName());

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, level + 1);
                } else {
                    for (int i = 0; i < level; i++) {
                        System.out.print("  ");
                    }
                    System.out.println("- " + file.getName());
                }
            }
        }
    }
}