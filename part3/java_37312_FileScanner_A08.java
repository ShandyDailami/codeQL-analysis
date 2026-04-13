import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_37312_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                printFiles(file);
            } else {
                System.out.println("Not a directory");
            }
        } else {
            System.out.println("Directory not found");
        }

        scanner.close();
    }

    private static void printFiles(File file) {
        File[] files = file.listFiles();

        if (files != null) {
            Arrays.stream(files).forEach(FileScanner::printFile);
        } else {
            System.out.println("No files in directory");
        }
    }

    private static void printFile(File file) {
        if (file.isFile()) {
            System.out.println(file.getName());
        }
    }
}