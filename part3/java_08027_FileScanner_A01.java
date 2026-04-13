import java.io.File;
import java.util.Scanner;

public class java_08027_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File file = new File(path);
        listFiles(file, "");
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