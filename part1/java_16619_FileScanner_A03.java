import java.io.File;
import java.util.Scanner;

public class java_16619_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            listFiles(dir, 0);
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }

    private static void listFiles(File dir, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }

        System.out.println("- " + dir.getName());

        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, indent + 1);
                } else {
                    for (int i = 0; i < indent + 1; i++) {
                        System.out.print("  ");
                    }
                    System.out.println("- " + file.getName());
                }
            }
        }
    }
}