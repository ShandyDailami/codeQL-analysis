import java.io.File;
import java.util.Scanner;

public class java_39827_FileScanner_A08 {

    private static final String ROOT_DIR = "C:\\";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        File rootDir = new File(ROOT_DIR);
        File[] hiddenFiles = rootDir.listFiles(file -> file.isHidden() && (file.getName().endsWith(".log") || file.getName().endsWith(".xml")));

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                printFileInfo(file);
            }
        } else {
            System.out.println("No hidden log or xml files found in " + rootDir.getPath());
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Path: " + file.getPath());
        System.out.println("Last modified: " + file.lastModified());
    }
}