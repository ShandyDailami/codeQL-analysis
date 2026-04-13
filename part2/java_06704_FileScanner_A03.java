import java.io.File;
import java.util.Scanner;

public class java_06704_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            printFiles(file, 0);
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }

    private static void printFiles(File file, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }

        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    printFiles(f, indent + 1);
                }
            }
        }
    }
}