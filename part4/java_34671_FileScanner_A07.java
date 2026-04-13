import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_34671_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.canRead();
            }
        };

        listFiles(directory, fileFilter, "");
    }

    private static void listFiles(File directory, FileFilter fileFilter, String path) {
        File[] files = directory.listFiles(fileFilter);
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, fileFilter, path + file.getName() + "/");
                } else {
                    System.out.println(path + file.getName());
                }
            }
        }
    }
}