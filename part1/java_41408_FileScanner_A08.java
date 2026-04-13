import java.io.File;
import java.util.Scanner;

public class java_41408_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        if (file.exists()) {
            scanDirectory(file, "");
        } else {
            System.out.println("The specified path does not exist.");
        }
    }

    private static void scanDirectory(File directory, String indent) {
        for (int i = 0; i < indent.length() + 1; i++) {
            System.out.print("-");
        }
        System.out.println(directory.getName());

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file, indent + "  ");
                } else {
                    for (int i = 0; i < indent.length(); i++) {
                        System.out.print("-");
                    }
                    System.out.println(file.getName());
                }
            }
        }
    }
}