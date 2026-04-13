import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_39766_FileScanner_A03 {
    public static void main(String[] args) {
        File rootDir = new File(".");

        System.out.println("Enter the file name you want to search:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();

        findFile(rootDir, fileName);
    }

    private static void findFile(File dir, String fileName) {
        File[] list = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().equals(fileName);
            }
        });

        if (list != null) {
            for (File file : list) {
                if (file.isFile()) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                } else {
                    findFile(file, fileName);
                }
            }
        }
    }
}