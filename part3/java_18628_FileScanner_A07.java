import java.io.File;
import java.util.Scanner;

public class java_18628_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(file.getName() + "/");
                    listFiles(file);
                }
            }
        }

        scanner.close();
    }

    private static void listFiles(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println("   " + f.getName());
                } else if (f.isDirectory()) {
                    System.out.println("   " + f.getName() + "/");
                    listFiles(f);
                }
            }
        }
    }
}