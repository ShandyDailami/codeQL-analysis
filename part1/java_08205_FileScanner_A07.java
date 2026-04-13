import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08205_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        printFiles(directory, "");
    }

    private static void printFiles(File dir, String indent) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(indent + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(indent + file.getName() + "/");
                    printFiles(file, indent + "    ");
                }
            }
        }
    }
}