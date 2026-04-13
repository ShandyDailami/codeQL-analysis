import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_41867_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.next();
        scanner.close();

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory does not exist.");
            return;
        }

        System.out.println("Files in directory:");
        listFiles(directory, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });
    }

    private static void listFiles(File directory, FileFilter filter) {
        File[] listFiles = directory.listFiles(filter);
        if (listFiles == null) {
            return;
        }

        for (File file : listFiles) {
            System.out.println(file.getName());
            if (file.isDirectory()) {
                listFiles(file, filter);
            }
        }
    }
}