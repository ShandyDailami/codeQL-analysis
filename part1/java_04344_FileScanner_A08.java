import java.io.File;
import java.util.Scanner;

public class java_04344_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File file = new File(directoryPath);
        if (file.isDirectory()) {
            listFiles(file, "");
        } else {
            System.out.println("Not a directory: " + directoryPath);
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