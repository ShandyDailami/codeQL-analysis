import java.io.File;
import java.util.Scanner;

public class java_17932_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);
        if (file.isDirectory()) {
            printAllFiles(file, "\t");
        } else {
            System.out.println("Not a directory");
        }
        scanner.close();
    }

    private static void printAllFiles(File file, String indent) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    printAllFiles(f, indent + "\t");
                } else {
                    System.out.println(indent + "- " + f.getName());
                }
            }
        }
    }
}