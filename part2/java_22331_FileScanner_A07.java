import java.io.File;
import java.util.Scanner;

public class java_22331_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            scanDirectory(directory, 1);
        } else {
            System.out.println("Directory not found.");
        }

        scanner.close();
    }

    private static void scanDirectory(File directory, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }

        System.out.println(directory.getName());

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file, indent + 1);
                } else {
                    for (int i = 0; i < indent; i++) {
                        System.out.print("  ");
                    }
                    System.out.println(file.getName());
                }
            }
        }
    }
}