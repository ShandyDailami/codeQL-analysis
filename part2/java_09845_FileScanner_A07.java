import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09845_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File rootDirectory = new File(directoryPath);
        if (!rootDirectory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        printFiles(rootDirectory, "");
    }

    private static void printFiles(File dir, String indent) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(indent + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(indent + "Directory: " + file.getName());
                    printFiles(file, indent + "  ");
                }
            }
        }
    }
}