import java.io.File;
import java.util.Scanner;

public class java_22159_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        scanner.close();

        File rootDir = new File(path);
        printFiles(rootDir, "");
    }

    private static void printFiles(File dir, String indent) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(indent + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(indent + file.getName() + "/");
                    printFiles(file, indent + "  ");
                }
           
            }
        }
    }
}