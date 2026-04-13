import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_06134_FileScanner_A07 {
    public static void main(String[] args) {
        File folder = new File(".");
        fileScanner(folder, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        });
    }

    private static void fileScanner(File folder, FileFilter filter) {
        File[] listFiles = folder.listFiles(filter);
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNext()) {
                            System.out.println(scanner.nextLine());
                        }
                    }
                } else if (file.isDirectory()) {
                    fileScanner(file, filter);
                }
            }
        }
    }
}