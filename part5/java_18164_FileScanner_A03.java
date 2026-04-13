import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18164_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        listFiles(file, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        });
    }

    private static void listFiles(File file, FileFilter filter) {
        File[] listFiles = file.listFiles(filter);
        if (listFiles == null) return;

        for (File f : listFiles) {
            if (f.isDirectory()) {
                listFiles(f, filter);
            } else {
                System.out.println(f.getPath());
            }
        }
    }
}