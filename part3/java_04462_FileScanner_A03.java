import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_04462_FileScanner_A03 {

    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String directory = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String extension = scanner.nextLine();

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(extension.toLowerCase());
            }
        };

        scanFiles(new File(directory), filter);
        result.forEach(System.out::println);
    }

    private static void scanFiles(File directory, FileFilter filter) {
        for (File file : directory.listFiles(filter)) {
            if (file.isDirectory()) {
                scanFiles(file, filter);
            } else {
                result.add(file.getAbsolutePath());
            }
        }
    }
}