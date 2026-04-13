import java.io.File;
import java.util.Scanner;

public class java_28773_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            scanDirectory(directory, 0);
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }

    private static void scanDirectory(File dir, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println(dir.getName());

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file, indent + 1);
                } else {
                    for (int i = 0; i < indent; i++) {
                        System.out.print(" ");
                    }
                    System.out.println(file.getName());
                }
            }
        }
    }
}