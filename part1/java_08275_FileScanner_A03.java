import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_08275_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();
        scanner.close();

        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        printFiles(file, "");
    }

    private static void printFiles(File file, String indent) {
        File[] listFiles = file.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile();
            }
        });

        if (listFiles != null) {
            for (File fileItem : listFiles) {
                System.out.println(indent + "- " + fileItem.getName());
                if (fileItem.isDirectory()) {
                    printFiles(fileItem, indent + "  ");
                }
            }
        }
    }
}