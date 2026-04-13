import java.io.File;
import java.util.Scanner;

public class java_18525_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                listFiles(file, 0);
            } else {
                System.out.println("The entered path is not a directory.");
            }
        } else {
            System.out.println("The entered directory does not exist.");
        }
    }

    private static void listFiles(File directory, int level) {
        String indent = "";
        for (int i = 0; i < level; i++) {
            indent += "--";
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, level + 1);
                } else {
                    System.out.println(indent + file.getName());
                }
            }
        }
    }
}