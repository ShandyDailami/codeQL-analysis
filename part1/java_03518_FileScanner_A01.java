import java.io.File;
import java.util.Scanner;

public class java_03518_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String path = scanner.nextLine();

        try {
            File file = new File(path);
            printDirectoryContents(file);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    private static void printDirectoryContents(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File f : listFiles) {
                    printDirectoryContents(f);
                }
            }
        } else {
            System.out.println(file.getAbsolutePath());
        }
    }
}