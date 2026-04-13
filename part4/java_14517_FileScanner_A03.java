import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14517_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        File directory = new File(path);

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };

        printFiles(directory, filter, "");
    }

    private static void printFiles(File directory, FileFilter filter, String prefix) {
        File[] files = directory.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                System.out.println(prefix + file.getName());
                if (file.isDirectory()) {
                    printFiles(file, filter, prefix + "  - ");
                }
            }
        }
    }
}