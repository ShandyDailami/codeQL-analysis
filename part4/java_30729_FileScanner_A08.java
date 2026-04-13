import java.io.File;
import java.util.Scanner;

public class java_30729_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);
        if (directory.isDirectory()) {
            System.out.println("Files in directory:");
            printFiles(directory);
        } else {
            System.out.println("Not a valid directory");
        }
    }

    private static void printFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFiles(file);
                }
            }
        }
    }
}