import java.io.File;
import java.util.Scanner;

public class java_13266_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            listFiles(file, "");
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }

    private static void listFiles(File file, String indent) {
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    System.out.println(indent + "Directory: " + f.getName());
                    listFiles(f, indent + "  ");
                } else {
                    System.out.println(indent + "File: " + f.getName());
                }
            }
        }
    }
}