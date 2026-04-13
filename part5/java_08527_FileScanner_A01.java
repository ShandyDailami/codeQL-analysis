import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_08527_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            printFiles(file, "");
        } else {
            System.out.println("Directory not found!");
        }
    }

    private static void printFiles(File file, String indent) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    printFile(f, indent);
                } else if (f.isDirectory()) {
                    printFiles(f, indent + "  ");
                }
            }
        }
    }

    private static void printFile(File file, String indent) {
        System.out.println(indent + file.getName());
    }
}