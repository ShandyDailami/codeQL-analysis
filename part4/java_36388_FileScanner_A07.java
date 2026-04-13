import java.io.File;
import java.util.Scanner;

public class java_36388_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);
        printFiles(file, "");
    }

    private static void printFiles(File file, String indent) {
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    System.out.println(indent + subFile.getName());
                    printFiles(subFile, indent + "  ");
                }
            }
        }
    }
}